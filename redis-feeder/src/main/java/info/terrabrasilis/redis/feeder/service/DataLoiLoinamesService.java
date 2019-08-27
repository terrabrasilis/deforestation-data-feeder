package info.terrabrasilis.redis.feeder.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.terrabrasilis.redis.feeder.domain.Data;
import info.terrabrasilis.redis.feeder.domain.DataLoiLoinames;
import info.terrabrasilis.redis.feeder.repository.DataLoiLoinamesRepository;

@Service
public class DataLoiLoinamesService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2971953909099479304L;
	
	@Autowired private DataLoiLoinamesRepository dataLoiLoinamesRepository;
	
	/**
	 * 
	 * @param dataLoiLoinamesRepository
	 */
	public DataLoiLoinamesService(DataLoiLoinamesRepository dataLoiLoinamesRepository) {
		super();
		this.dataLoiLoinamesRepository = dataLoiLoinamesRepository;
	}

	public List<DataLoiLoinames> findAllByData(Data data) {		
		List<DataLoiLoinames> dataLoiLoinames = dataLoiLoinamesRepository.findAllByData(data);
		return dataLoiLoinames == null ? new ArrayList<DataLoiLoinames>() : dataLoiLoinames;
	}

}
