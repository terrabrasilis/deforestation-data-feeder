package info.terrabrasilis.redis.feeder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import info.terrabrasilis.redis.feeder.domain.Data;
import info.terrabrasilis.redis.feeder.domain.Period;

@Repository
public interface PeriodRepository extends JpaRepository<Period, Integer> {
	List<Period> findAllByData(Data data);
}
