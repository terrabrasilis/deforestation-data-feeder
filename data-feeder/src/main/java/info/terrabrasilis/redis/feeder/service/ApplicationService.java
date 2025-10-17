package info.terrabrasilis.redis.feeder.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.terrabrasilis.redis.feeder.domain.Application;
import info.terrabrasilis.redis.feeder.repository.ApplicationRepository;

/**
 * 
 * @author jether
 *
 */
@Service
public class ApplicationService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9185643402092413738L;
	
	@Autowired
	private ApplicationRepository applicationRepository;

	/**
	 * @param applicationRepository
	 */
	public ApplicationService(ApplicationRepository applicationRepository) {
		this.applicationRepository = applicationRepository;
	}
	
	public List<Application> findAll() {
		return this.applicationRepository.findAll();
	}
	
	public void save(Application application) {		
		this.applicationRepository.save(application);
	}
	
	public Application findByIdentifier(String identifier) {
		return applicationRepository.findByIdentifier(identifier);
	}
}
