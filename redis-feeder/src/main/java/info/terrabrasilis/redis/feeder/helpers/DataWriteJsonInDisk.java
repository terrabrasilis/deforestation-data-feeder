package info.terrabrasilis.redis.feeder.helpers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import info.terrabrasilis.redis.feeder.interfaces.Writable;

/**
 * 
 * @author jether
 *
 */
@Component("dataWriteJsonInDisk")
public class DataWriteJsonInDisk implements Writable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8974886460113498736L;
	private static final Logger logger = LoggerFactory.getLogger(DataWriteJsonInDisk.class);
	
	
	@Override
	public void write(String key, Object data) {
		logger.info("Start write json in disk: {}", LocalDateTime.now());
		
		StringBuilder builder = new StringBuilder();
		// builder.append(System.getProperty("java.io.tmpdir"))
		builder.append("/tmp/")
			   .append(File.separator)
			   .append(String.join(".", key, "json"));
		
		File json = new File(builder.toString());
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(json))) {
			writer.write(new Gson().toJson(data));	
		} catch (IOException writerException) {
			logger.error("Error on try to write in file: {}", writerException.getMessage());
		} 
		
		logger.info("Finish write json in disk: {}. Path: {}", LocalDateTime.now(), json.toPath());
	}

	@Override
	public void write(Object data, String host, String key) {
		logger.info("Start write json in disk: {}", LocalDateTime.now());
		
		StringBuilder builder = new StringBuilder();
		// builder.append(System.getProperty("java.io.tmpdir"))
		builder.append("/tmp/")
				.append(host)
				.append(File.separator)
				.append(String.join(".", key, "json"));
		
		File json = new File(builder.toString());
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(json))) {
			writer.write(new Gson().toJson(data));	
		} catch (IOException writerException) {
			logger.error("Error on try to write in file: {}", writerException.getMessage());
		} 
		
		logger.info("Finish write json in disk: {}. Path: {}", LocalDateTime.now(), json.toPath());
	}

}
