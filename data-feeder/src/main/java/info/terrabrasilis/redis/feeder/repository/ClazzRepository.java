package info.terrabrasilis.redis.feeder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import info.terrabrasilis.redis.feeder.domain.Clazz;

public interface ClazzRepository extends JpaRepository<Clazz, Integer> {

}
