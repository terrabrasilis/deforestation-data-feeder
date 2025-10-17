package info.terrabrasilis.redis.feeder.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.terrabrasilis.redis.feeder.domain.Clazz;
import info.terrabrasilis.redis.feeder.domain.Data;
import info.terrabrasilis.redis.feeder.domain.DataClazz;
import info.terrabrasilis.redis.feeder.repository.DataClazzRepository;

@Service
public class DataClazzService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8605322092484729546L;
	
	@Autowired private DataClazzRepository dataClassRepository;
	
	/**
	 * 
	 * @param dataClassRepository
	 */
	public DataClazzService(DataClazzRepository dataClassRepository) {
		super();
		this.dataClassRepository = dataClassRepository;
	}

	/**
	 * 
	 * @param data
	 * @return empty list or List<DataClass>
	 */
	public List<DataClazz> findAllByData(Data data) {
		List<DataClazz> dataClasses = dataClassRepository.findAllByData(data);
		return dataClasses == null ? new ArrayList<DataClazz>() : dataClasses;
	}
	
	/**
	 * 
	 * @param clazz
	 * @return empty list or List<DataClass>
	 */
	public List<DataClazz> findAllByClass(Clazz clazz) {
		List<DataClazz> dataClasses = dataClassRepository.findAllByClazz(clazz);
		return dataClasses == null ? new ArrayList<DataClazz>() : dataClasses;
	}
}
