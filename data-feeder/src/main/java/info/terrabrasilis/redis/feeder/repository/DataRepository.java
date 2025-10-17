package info.terrabrasilis.redis.feeder.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import info.terrabrasilis.redis.feeder.domain.Data;

/**
 * 
 * @author jether
 *
 */
@Repository
public interface DataRepository extends JpaRepository<Data, Integer>{
	Optional<Data> findByName(String name);
}
