package info.terrabrasilis.redis.feeder.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.terrabrasilis.redis.feeder.domain.Clazz;
import info.terrabrasilis.redis.feeder.repository.ClazzRepository;

/**
 * 
 * @author jether
 *
 */
@Service
public class ClazzService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4868952711280760520L;
	
	@Autowired private ClazzRepository classRepository;
		
	/**
	 * @param classRepository
	 */
	public ClazzService(ClazzRepository classRepository) {
		super();
		this.classRepository = classRepository;
	}

	public List<Clazz> findAll() {
		List<Clazz> classes = classRepository.findAll(); 
		return classes == null ? new ArrayList<Clazz>() : classes; 
	}
}
