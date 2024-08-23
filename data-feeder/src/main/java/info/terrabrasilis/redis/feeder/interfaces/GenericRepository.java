package info.terrabrasilis.redis.feeder.interfaces;

import java.util.List;

/**
 * 
 * @author jether
 *
 * @param <T>
 */
public interface GenericRepository<T> {
	void save(T t);	
	void update(T t);
	List<T> findAll();
}
