package info.terrabrasilis.redis.feeder.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.terrabrasilis.redis.feeder.domain.Loi;
import info.terrabrasilis.redis.feeder.domain.LoiLoinames;
import info.terrabrasilis.redis.feeder.repository.LoiLoinamesRepository;

/**
 * 
 * @author jether
 *
 */
@Service
public class LoiLoinamesService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5665190835907614254L;

	@Autowired private LoiLoinamesRepository loiLoinamesRepository;
	
	public List<LoiLoinames> findAllByLoi(Loi loi) {
		List<LoiLoinames> loiLoinames = loiLoinamesRepository.findAllByLoi(loi);
		return loiLoinames == null ? new ArrayList<LoiLoinames>() : loiLoinames;
	}
}
