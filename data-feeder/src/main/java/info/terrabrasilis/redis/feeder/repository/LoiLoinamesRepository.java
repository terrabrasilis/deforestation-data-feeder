package info.terrabrasilis.redis.feeder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import info.terrabrasilis.redis.feeder.domain.Loi;
import info.terrabrasilis.redis.feeder.domain.LoiLoinames;
import info.terrabrasilis.redis.feeder.domain.Loinames;

@Repository
public interface LoiLoinamesRepository extends JpaRepository<LoiLoinames, Long> {
	List<LoiLoinames> findAllByLoi(Loi loi);
	List<LoiLoinames> findAllByLoinames(Loinames loinames);
}
