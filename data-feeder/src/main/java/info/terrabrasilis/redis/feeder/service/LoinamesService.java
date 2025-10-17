package info.terrabrasilis.redis.feeder.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.terrabrasilis.redis.feeder.domain.Loinames;
import info.terrabrasilis.redis.feeder.repository.LoinamesRespository;

/**
 * 
 * @author jether
 *
 */
@Service
public class LoinamesService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5025974431904173416L;
	
	@Autowired private LoinamesRespository loinamesRespository;

	/**
	 * @param loinamesRespository
	 */
	public LoinamesService(LoinamesRespository loinamesRespository) {
		super();
		this.loinamesRespository = loinamesRespository;
	}
	
	public List<Loinames> findAll() {
		List<Loinames> loinames = loinamesRespository.findAll();
		return loinames == null ? new ArrayList<Loinames>() : loinames;
	}
		
	public Loinames findById(Integer id) {
		return loinamesRespository.getOne(id);
	}
 }
