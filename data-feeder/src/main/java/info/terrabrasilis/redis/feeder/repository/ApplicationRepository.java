package info.terrabrasilis.redis.feeder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import info.terrabrasilis.redis.feeder.domain.Application;

/**
 * 
 * @author jether
 *
 */
@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
	Application findByIdentifier(String identifier);
}
