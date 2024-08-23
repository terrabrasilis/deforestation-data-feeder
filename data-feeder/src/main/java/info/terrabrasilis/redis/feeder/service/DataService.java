package info.terrabrasilis.redis.feeder.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.terrabrasilis.redis.feeder.domain.Data;
import info.terrabrasilis.redis.feeder.repository.DataRepository;

/**
 * 
 * @author jether
 *
 */
@Service
public class DataService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7942620162160139599L;
	
	@Autowired private DataRepository dataRepository;
	
	/**
	 * 
	 * @param dataRepository
	 */
	public DataService(DataRepository dataRepository) {
		super();
		this.dataRepository = dataRepository;
	}

	public Optional<Data> findById(Integer id) {
		return dataRepository.findById(id);
	}
	
	public Optional<Data> findByName(String name) {
		return dataRepository.findByName(name);
	}
	
	public List<Data> findAll() {
		List<Data> datas = dataRepository.findAll(); 
		return datas == null ? new ArrayList<Data>() : datas;
	}
 }
