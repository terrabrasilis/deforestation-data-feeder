package info.terrabrasilis.redis.feeder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import info.terrabrasilis.redis.feeder.domain.Clazz;
import info.terrabrasilis.redis.feeder.domain.Data;
import info.terrabrasilis.redis.feeder.domain.DataClazz;

/**
 * 
 * @author jether
 *
 */
@Repository
public interface DataClazzRepository extends JpaRepository<DataClazz, Long> {
	List<DataClazz> findAllByData(Data data);

	List<DataClazz> findAllByClazz(Clazz clazz);
}
