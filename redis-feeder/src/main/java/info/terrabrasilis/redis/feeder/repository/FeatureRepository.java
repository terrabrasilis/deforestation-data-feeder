package info.terrabrasilis.redis.feeder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import info.terrabrasilis.redis.feeder.domain.Feature;

/**
 * 
 * @author jether
 *
 */
@Repository
public interface FeatureRepository extends JpaRepository<Feature, String> {
}
