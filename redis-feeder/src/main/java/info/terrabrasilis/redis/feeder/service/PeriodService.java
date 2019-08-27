package info.terrabrasilis.redis.feeder.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.terrabrasilis.redis.feeder.domain.Data;
import info.terrabrasilis.redis.feeder.domain.Period;
import info.terrabrasilis.redis.feeder.repository.PeriodRepository;

/**
 * 
 * @author jether
 *
 */
@Service
public class PeriodService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8597683796301882347L;
	
	@Autowired private PeriodRepository periodRepository;

	/**
	 * 
	 * @param periodRepository
	 */
	public PeriodService(PeriodRepository periodRepository) {
		super();
		this.periodRepository = periodRepository;
	}
	
	public List<Period> findAllByData(final Data data) {
		List<Period> periods = periodRepository.findAllByData(data);
		return periods == null ? new ArrayList<Period>() : periods;
	}
	
}
