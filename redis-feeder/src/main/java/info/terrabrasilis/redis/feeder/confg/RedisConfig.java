package info.terrabrasilis.redis.feeder.confg;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


/**
 * 
 * @author jether
 *
 * http://oppalove.com/2017/03/06/spring-boot-redis-json-examlpe/?i=1
 * http://javasampleapproach.com/spring-framework/spring-data/spring-data-redis-example-spring-boot-redis-example
 * http://www.baeldung.com/spring-data-redis-tutorial
 * 
 */
@Configuration
@EnableAutoConfiguration
public class RedisConfig {	
	
	@Value("${spring.redis.host}")
    private String redisHostName;

    @Value("${spring.redis.port}")
    private int redisPort;
    
    JedisPool jedisPool() {
    	JedisPoolConfig poolConfig = new JedisPoolConfig();
    	poolConfig.setMaxTotal(20);
    	poolConfig.setMinIdle(2);
    	poolConfig.setMaxIdle(5);
    	
    	return new JedisPool(poolConfig, redisHostName, redisPort);
    }
    
    Jedis jedis() {
    	return new Jedis(redisHostName, redisPort);
    }
    
    /**
	 * https://github.com/spring-projects/spring-data-examples/tree/master/redis/repositories
	 * Using: https://github.com/lettuce-io/lettuce-core (reactive)
	 * 
	 * https://docs.spring.io/spring-data/data-redis/docs/current/reference/html/#redis:reactive
	 * 
	 * @return LettuceConnectionFactory
	 */	
	@Bean
	RedisConnectionFactory redisConnectionFactory() {
		return new LettuceConnectionFactory(this.redisHostName, this.redisPort);
	}
	
	@Bean(name="jedisToJReJSON")
	public Jedis jedisConnection() {		
		return jedis();
	}
	 
	@Bean
	public <T> RedisTemplate<String, T> redisTemplate() {
		final RedisTemplate<String, T> template = new RedisTemplate<String, T>();
		template.setConnectionFactory(redisConnectionFactory());
		
		template.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());
		template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		template.setKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.setHashKeySerializer(new GenericJackson2JsonRedisSerializer());
        template.setStringSerializer(new StringRedisSerializer());
        
		return template;
	}
}
