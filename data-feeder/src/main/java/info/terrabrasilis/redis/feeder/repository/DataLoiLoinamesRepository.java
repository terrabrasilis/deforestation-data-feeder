package info.terrabrasilis.redis.feeder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import info.terrabrasilis.redis.feeder.domain.Data;
import info.terrabrasilis.redis.feeder.domain.DataLoiLoinames;
import info.terrabrasilis.redis.feeder.domain.LoiLoinames;

@Repository
public interface DataLoiLoinamesRepository extends JpaRepository<DataLoiLoinames, Long>{
	List<DataLoiLoinames> findAllByData(Data data);
	List<DataLoiLoinames> findAllByLoiLoinames(LoiLoinames loiLoinames);
}
