package info.terrabrasilis.redis.feeder.service;

import static info.terrabrasilis.redis.feeder.util.Constants.APP_IDENTIFIER_KEY;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import info.terrabrasilis.redis.feeder.dto.ApplicationData;
import info.terrabrasilis.redis.feeder.interfaces.Data;
import info.terrabrasilis.redis.feeder.repository.ApplicationDataRepository;

@Service
public class ApplicationDataService implements Serializable, ApplicationDataRepository {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9185643402092413738L;	
	
	@Autowired private RedisTemplate<String, String> redisTemplate;
	@Autowired private JReJSONService jReJsonService;
	
	private ValueOperations<String, String> valueOperations;	
	
	public ApplicationDataService(RedisTemplate<String, String> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
	
	@PostConstruct
	private void init() {		
		this.valueOperations = this.redisTemplate.opsForValue();
	}
	
	@Override
	public void save(List<Data> applications) {
		if(!this.redisTemplate.hasKey(APP_IDENTIFIER_KEY)) {
			this.jReJsonService.set(APP_IDENTIFIER_KEY, applications);
		} else {
			this.update(applications);
		}
	}

	@Override
	public void update(List<Data> applications) {
		this.redisTemplate.delete(APP_IDENTIFIER_KEY);
		this.jReJsonService.set(APP_IDENTIFIER_KEY, applications);
	}

	@Override
	public Optional<Data> find(String identifier) {		
		return new ApplicationData().convertJSONToListOfT(this.valueOperations.get(APP_IDENTIFIER_KEY))
					.parallelStream()
					.filter(app -> app.getIdentifier().equals(identifier))
					.collect(Collectors.reducing((a, b) -> null));		
	}

	@Override
	public void delete() {
		this.redisTemplate.delete(APP_IDENTIFIER_KEY);
	}
}
