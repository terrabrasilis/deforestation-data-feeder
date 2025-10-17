package info.terrabrasilis.redis.feeder.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.terrabrasilis.redis.feeder.vo.AreaVO;
import info.terrabrasilis.redis.feeder.vo.FeatureFilterVO;
import java.util.HashMap;
import java.util.Map;
import org.jooq.Record;
import org.jooq.Result;

@Service
public class FeatureVOService implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 532303939847838591L;
    private static final String FILTER_NAME = "filter";

    private final Map<Integer, String> filterMap = new HashMap<>();

    @Autowired private DSLContext dsl;

    public List<FeatureFilterVO> findAllByDataAndClazzAndPeriod(int idData, int idClazz, int idPeriod) {
            StringBuilder sql = new StringBuilder();
            sql.append("WITH grouped_fids AS ")
                    .append("( SELECT id_data_loi_loinames, ") 
                    .append("   left(gid_polygon, strpos(gid_polygon, '_')-1) AS gid_polygon, ") 
                    //.append("       ST_Union(geom) as geom, ") 
                    .append("       sum(area_km2) AS fid_area ") 
                    .append("   FROM features f ") 
                    .append("       INNER JOIN data_class dc ON (dc.id = f.id_data_class) ") 
                    .append("       INNER JOIN data d ON (dc.id_data = d.id AND d.id = ?) ") 
                    .append("       INNER JOIN class c ON (dc.id_class = c.id AND c.id = ?) ") 
                    .append("       WHERE id_period = ? ") 
                    .append("    GROUP BY id_data_loi_loinames, gid_polygon ") 
                    //.append("    LIMIT 10 ") 
                    .append(" )")
                    .append("SELECT l.id as loi, ") 
                    .append("	lns.gid as loiname, ") 
                    .append(this.mountFilters(idData))
                    .append(" FROM grouped_fids g ")
                    .append("   INNER JOIN data_loi_loinames dll ON (dll.id = g.id_data_loi_loinames) ") 
                    .append("   INNER JOIN loi_loinames ll ON (ll.id = dll.id_loi_loinames) ") 
                    .append("   INNER JOIN loi l ON (l.id = ll.id_loi) ") 
                    .append("   INNER JOIN loinames lns ON (lns.gid = ll.gid_loinames) ") 
                    .append("  GROUP BY loi, loiname ");

            List<FeatureFilterVO> features = dsl.fetch(sql.toString(), idData, idClazz, idPeriod)
                    .stream()
                    .map(rs -> {
                        List<AreaVO> filters = filterMap.keySet().stream().map(key -> AreaVO.of(key, (Double) rs.get(FILTER_NAME + key))).collect(Collectors.toList());

                        return FeatureFilterVO.of(
                                (Integer) rs.get("loi")
                                , (Integer) rs.get("loiname")
                                , filters.toArray(new AreaVO[filters.size()])
                        );
                    }).collect(Collectors.toCollection(ArrayList::new));

            return features;
    }

    private String mountFilters(int idData) {
        String sql = "SELECT f.id, f.type FROM filter f INNER JOIN data_filter df ON (df.id_filter = f.id AND df.id_data = ?) INNER JOIN data d ON (df.id_data = d.id)";
        StringBuilder builder = new StringBuilder();

        Result<Record> records = dsl.fetch(sql, idData);

        for (int index = 0; index < records.size(); index++) {
            final Integer id = (Integer) records.getValue(index, "id");
            final String type = (String) records.getValue(index, "type");
            final String filterName = FILTER_NAME + id;

            filterMap.put(id, type);

            // builder.append(" SUM(CASE WHEN ( ")
            //        .append(type)
            //        .append(" ) THEN fid_area ELSE 0 END) AS ")
            //        .append(filterName);
            builder.append(" SUM( fid_area ) AS ")
                   .append(filterName);

            if(index < (records.size() - 1)) builder.append(", ");

        } 
        return builder.toString();
    }   
}
