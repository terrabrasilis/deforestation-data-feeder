package info.terrabrasilis.redis.feeder.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.terrabrasilis.redis.feeder.interfaces.Data;
import info.terrabrasilis.redis.feeder.vo.LoinamesVO;

/**
 * 
 * @author jether
 *
 */
@Service
public class LoinamesVOService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -29403017048794482L;
	
	@Autowired DSLContext dsl;
	
	public List<Data> findAllByLoi(Integer idLoi, Integer idData) {
		StringBuilder sql = new StringBuilder();
		sql.append("select l.gid, l.name from data_loi_loinames as ll ")
			.append(" inner join loi_loinames as lns on (ll.id_loi_loinames = lns.id AND lns.id_loi = ?) ")
			.append(" inner join loinames l on (lns.gid_loinames = l.gid) ")
			.append(" where ll.id_data = ?")
			.append(" group by 1,2");
			
		return dsl.fetch(sql.toString(), idLoi, idData)
				.stream()
				.map(rs -> {
					return new LoinamesVO((Integer) rs.get("gid"), (String) rs.get("name"));
				}).collect(Collectors.toCollection(ArrayList::new));
	}

}
