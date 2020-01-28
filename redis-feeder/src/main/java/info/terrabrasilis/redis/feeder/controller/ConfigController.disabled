package info.terrabrasilis.redis.feeder.controller;

import info.terrabrasilis.redis.feeder.domain.Config;
import static info.terrabrasilis.redis.feeder.util.Constants.CONFIG;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import info.terrabrasilis.redis.feeder.helpers.DataPostInRedisCliApi;
import info.terrabrasilis.redis.feeder.interfaces.Writable;
import info.terrabrasilis.redis.feeder.service.ConfigService;
import java.io.IOException;

/**
 * @author jether.rodrigues
 */
@Controller
@EnableScheduling
public class ConfigController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ConfigController.class);
	
	@Autowired private final ConfigService configService;
	
	@Autowired @Qualifier("dataPostInRedisCliApi") private final Writable writable;

        public ConfigController(ConfigService configService, DataPostInRedisCliApi writable) {
            this.configService = configService;
            this.writable = writable;
        }

        /**
	 * This service will post CONFIGs in REDIS by API
	 */
	//@Scheduled(cron = "0 */1 * * * *")
    /*    public void redisConfigData() {
            LOGGER.info("Starting RedisConfig: {}", LocalDateTime.now());
            
            configService.findAll().forEach(config -> {
                try {
                    String [] split = config.getKey().split("\\#");
                    Config conf = Config.of(split[1], config.getValue());

                    writable.write(conf.getValue(), CONFIG + conf.getKey(), split[0]);
                    
                } catch (Exception e) {
                    LOGGER.error("Error: {}", e.getMessage());
                }
            });
            
            try {
                writable.close();
            } catch (IOException e) {
                LOGGER.error("Error: {}", e.getMessage());
            }
            
            LOGGER.info("Finish RedisConfig: {}", LocalDateTime.now());
        } */
}
