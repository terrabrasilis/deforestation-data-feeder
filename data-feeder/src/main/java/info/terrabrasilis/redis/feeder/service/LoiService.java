package info.terrabrasilis.redis.feeder.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.terrabrasilis.redis.feeder.domain.Loi;
import info.terrabrasilis.redis.feeder.repository.LoiRepository;

/**
 * 
 * @author jether
 *
 */
@Service
public class LoiService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1062702667329640711L;

	@Autowired private LoiRepository loiRepository;

	/**
	 * @param loiRepository
	 */
	public LoiService(LoiRepository loiRepository) {
		super();
		this.loiRepository = loiRepository;
	}
	
	public List<Loi> finAll() {
		List<Loi> lois = loiRepository.findAll();
		return lois == null ? new ArrayList<Loi>() : lois;
 	}
}
