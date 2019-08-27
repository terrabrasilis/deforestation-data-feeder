package info.terrabrasilis.redis.feeder.helpers;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import info.terrabrasilis.redis.feeder.interfaces.Writable;
import info.terrabrasilis.redis.feeder.service.JReJSONService;
import java.io.IOException;

/**
 * 
 * @author jether
 *
 */
@Component("dataWriteInRedis")
public class DataWriteInRedis implements Writable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1208505051516579151L;
	private static final Logger logger = LoggerFactory.getLogger(DataWriteInRedis.class);
	
	@Autowired private JReJSONService jReJsonService;
	
	@Override
	public void write(String key, Object data) {
		logger.info("Start send data to Redis: {}", LocalDateTime.now());
		
		jReJsonService.set(key, data);
		
		logger.info("Finish send data to Redis: {}", LocalDateTime.now());
	}
}
