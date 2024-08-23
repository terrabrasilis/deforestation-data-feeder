package info.terrabrasilis.redis.feeder.service;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.terrabrasilis.redis.feeder.vo.FilterVO;

@Service
public class FilterVOService implements Serializable {
    
        private static final long serialVersionUID = 1L;
        
	@Autowired private DSLContext dsl;
	
        public List<FilterVO> findAllByData(int idData) {
            String sql = "SELECT f.id, f.type FROM filter f INNER JOIN data_filter df ON (df.id_filter = f.id AND df.id_data = ?) INNER JOIN data d ON (df.id_data = d.id)";
            
            return dsl.fetch(sql, idData).stream()
                        .map(rs -> FilterVO.of((Integer) rs.get("id"), (String) rs.get("type")))
                        .collect(Collectors.toList());
        }
}
