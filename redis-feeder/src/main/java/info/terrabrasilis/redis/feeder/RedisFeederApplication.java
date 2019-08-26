package info.terrabrasilis.redis.feeder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

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

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(RedisFeederApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(RedisFeederApplication.class, args);
	}

}
