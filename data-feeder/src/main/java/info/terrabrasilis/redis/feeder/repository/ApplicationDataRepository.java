package info.terrabrasilis.redis.feeder.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import info.terrabrasilis.redis.feeder.interfaces.Data;

/**
 * 
 * @author jether
 *
 */
@Repository
public interface ApplicationDataRepository {
	
	Optional<Data> find(String identifier);
	
	public default List<Data> findAll() {
		return null;
	};
	
	void delete();
	void save(List<Data> applications);
	void update(List<Data> applications);
}
