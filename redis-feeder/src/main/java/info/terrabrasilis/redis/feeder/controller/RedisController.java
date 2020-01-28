package info.terrabrasilis.redis.feeder.controller;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import info.terrabrasilis.redis.feeder.domain.Application;
import info.terrabrasilis.redis.feeder.dto.ApplicationData;
import info.terrabrasilis.redis.feeder.service.ApplicationDataService;
import info.terrabrasilis.redis.feeder.service.ApplicationService;

/**
 * 
 * @author jether
 *
 */
@Controller
@EnableScheduling
public class RedisController implements Serializable {

	private static final String TIME_ZONE = "America/Sao_Paulo";

	/**
	 * 
	 */
	private static final long serialVersionUID = -1467262120504124974L;
	private static final Logger logger = LoggerFactory.getLogger(RedisController.class);

	
	@Autowired
	private ApplicationService applicationService;
	
	@Autowired
	private ApplicationDataService applicationDataService;

	/**
	 * @param applicationService
	 * @param applicationDataService
	 */
	public RedisController(ApplicationService applicationService, ApplicationDataService applicationDataService) {
		this.applicationService = applicationService;
		this.applicationDataService = applicationDataService;
	}
	
	@Scheduled(cron = "0 05 * * * *")
    public void findAllApplicationAndPopulateInRedis() {
    	logger.info("Starting ApplicationRedisFeeder. {}", LocalDateTime.now());
    	this.applicationDataService.save(
    			this.applicationService.findAll()
	    			.parallelStream()
					.map(new Function<Application, ApplicationData>() {
						@Override
						public ApplicationData apply(Application t) {
							return new ApplicationData(t);
						}})
					.collect(Collectors.toCollection(ArrayList::new)));
    	logger.info("Finishing ApplicationRedisFeeder. {}", LocalDateTime.now());
    }
}
