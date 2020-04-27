package info.terrabrasilis.redis.feeder;

import info.terrabrasilis.redis.feeder.controller.RedisController;
import info.terrabrasilis.redis.feeder.controller.DataController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.annotation.PostConstruct;

/**
 * 
 * @author jether
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = "info.terrabrasilis.redis.feeder")
@EntityScan(basePackageClasses = {
		RedisFeederApplication.class,
		Jsr310JpaConverters.class 
})
public class RedisFeederApplication extends SpringBootServletInitializer{

  @Autowired private final RedisController redisController;
	@Autowired private final DataController dataController;

	public RedisFeederApplication(RedisController redisController, DataController dataController) {
		super();
		this.dataController=dataController;
		this.redisController=redisController;
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(RedisFeederApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(RedisFeederApplication.class, args);
	}

	@PostConstruct
	private void init() {
		this.redisController.findAllApplicationAndPopulateInRedis();
		this.dataController.redisDataClassFeeder();
		this.dataController.redisDataPeriodFeeder();
		this.dataController.redisDataLoisFeeder();
		this.dataController.redisDataLoiLoinamesFeeder();
		this.dataController.redisDataFilter();
		this.dataController.redisDataFeeder();
	}

}
