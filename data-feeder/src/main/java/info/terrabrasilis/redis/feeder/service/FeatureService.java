package info.terrabrasilis.redis.feeder.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.terrabrasilis.redis.feeder.repository.FeatureRepository;

/**
 * 
 * @author jether
 *
 */
@Service
public class FeatureService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5777323036112853632L;

	@Autowired
	private FeatureRepository featureRepository;

	/**
	 * @param featureRepository
	 */
	public FeatureService(FeatureRepository featureRepository) {
		super();
		this.featureRepository = featureRepository;
	}
	
}
