package info.terrabrasilis.redis.feeder.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.terrabrasilis.redis.feeder.vo.LoiVO;
import java.util.Collections;

/**
 * 
 * @author jether
 *
 */
@Service
public class LoiVOService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7250888804731353419L;

	@Autowired
	private DSLContext dsl;

	public List<LoiVO> findAllByData(Integer idData) {
		StringBuilder sql = new StringBuilder();
		sql.append("select l.id, l.name from data_loi_loinames as ll ")
			.append("	inner join loi_loinames as lns on (ll.id_loi_loinames = lns.id) ")
			.append("	inner join loi as l on (lns.id_loi = l.id) ")
			.append("	where ll.id_data = ? ")
			.append("	group by 1,2");
		
		return dsl.fetch(sql.toString(), idData)
				.stream()
				.map(rs -> {
					return LoiVO.of((Integer) rs.get("id"), (String) rs.get("name"), Collections.emptyList());
				}).collect(Collectors.toCollection(ArrayList::new));
	}
}
