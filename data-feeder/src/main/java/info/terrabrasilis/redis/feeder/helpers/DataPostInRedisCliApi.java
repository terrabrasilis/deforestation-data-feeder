package info.terrabrasilis.redis.feeder.helpers;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import info.terrabrasilis.redis.feeder.interfaces.Writable;
import java.io.Closeable;
import java.io.IOException;

/**
 * 
 * @author jether
 *
 * https://www.baeldung.com/unirest
 */
@Component("dataPostInRedisCliApi")
@Primary
public class DataPostInRedisCliApi implements Writable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1321878743398427614L;
	private static final Logger LOGGER = LoggerFactory.getLogger(DataWriteInRedis.class);
        
        @Override
	public void write(Object obj, String host) throws UnirestException {
		LOGGER.info("Start post data in the Redis: {}", LocalDateTime.now());
		
		HttpResponse<JsonNode> response= 
				Unirest.post(host)
					.header("Content-Type", "application/json")
					.body(new Gson().toJson(obj))
					.asJson();
		
		LOGGER.info("Finish post data in the Redis: {}.\n Response: {}", LocalDateTime.now(), response.getBody());
	}
	
	@Override
	public void write(Object obj, String host, String identifier) throws UnirestException {
		LOGGER.info("Start post data in the Redis: {}", LocalDateTime.now());
		
		HttpResponse<JsonNode> response= 
				Unirest.post(host)
					.header("Content-Type", "application/json")
					.header("App-Identifier", identifier)
					.body(new Gson().toJson(obj))
					.asJson();
		
		LOGGER.info("Finish post data in the Redis: {}.\n Response: {}", LocalDateTime.now(), response.getBody());
	}

    @Override
    public void close() throws IOException {
        Unirest.shutdown();
    }
}
