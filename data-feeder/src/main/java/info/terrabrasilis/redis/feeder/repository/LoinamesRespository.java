package info.terrabrasilis.redis.feeder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import info.terrabrasilis.redis.feeder.domain.Loinames;

@Repository
public interface LoinamesRespository extends JpaRepository<Loinames, Integer> {		
}
