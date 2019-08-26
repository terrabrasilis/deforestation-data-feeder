package info.terrabrasilis.redis.feeder.controller;

import static info.terrabrasilis.redis.feeder.util.Constants.DATA;
import static info.terrabrasilis.redis.feeder.util.Constants.DATA_LOI;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import info.terrabrasilis.redis.feeder.domain.Clazz;
import info.terrabrasilis.redis.feeder.interfaces.Data;
import info.terrabrasilis.redis.feeder.interfaces.Writable;
import info.terrabrasilis.redis.feeder.service.DataClazzService;
import info.terrabrasilis.redis.feeder.service.DataService;
import info.terrabrasilis.redis.feeder.service.FeatureVOService;
import info.terrabrasilis.redis.feeder.service.LoiVOService;
import info.terrabrasilis.redis.feeder.service.LoinamesVOService;
import info.terrabrasilis.redis.feeder.service.PeriodService;
import info.terrabrasilis.redis.feeder.vo.DataClassVO;
import info.terrabrasilis.redis.feeder.vo.DataLoiLoinamesVO;
import info.terrabrasilis.redis.feeder.vo.DataLoisVO;
import info.terrabrasilis.redis.feeder.vo.DataPeriodVO;
import info.terrabrasilis.redis.feeder.vo.DataVO;
import info.terrabrasilis.redis.feeder.vo.FeatureFilterVO;
import info.terrabrasilis.redis.feeder.vo.FeatureVO;
import info.terrabrasilis.redis.feeder.vo.LoiVO;
import info.terrabrasilis.redis.feeder.vo.PeriodVO;

@Controller
@EnableScheduling
public class DataController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7113482896095798000L;
	
	private static final Logger logger = LoggerFactory.getLogger(DataController.class);
	
	@Autowired private DataService dataService;	
	@Autowired private PeriodService periodService;
	@Autowired private FeatureVOService featureVOService;
	@Autowired private DataClazzService dataClassService;
	@Autowired private LoiVOService loiVOService;
	@Autowired private LoinamesVOService loinamesVOService;
	@Autowired private DataClazzService dataClazzService;
	
	@Autowired @Qualifier("dataPostInRedisCliApi") private Writable writable;

	public DataController(DataService dataService, PeriodService periodService, FeatureVOService featureVOService, DataClazzService dataClassService, LoiVOService loiVOService,
			LoinamesVOService loinamesVOService, Writable writable) {
		super();
		this.dataService = dataService;
		this.periodService = periodService;
		this.featureVOService = featureVOService;
		this.dataClassService = dataClassService;
		this.loiVOService = loiVOService;
		this.loinamesVOService = loinamesVOService;
		this.writable = writable;
	}

	/**
	 * This service will post DATA by CLASS and PERIOD in REDIS by API
	 */	
	@Scheduled(cron = "0 15 23 * * *")
	public void redisDataFeeder() {
		logger.info("Starting RedisDataFeeder: {}", LocalDateTime.now());
		
		List<DataVO> datas = new ArrayList<>();
						
		dataService.findAll().forEach(data -> {			
			List<Data> periods = new ArrayList<>();

			dataClazzService.findAllByData(data).forEach(dc -> {
				periodService.findAllByData(data).forEach(period -> {
					List<FeatureFilterVO> list = featureVOService.findAllByDataAndClazzAndPeriod(data.getId()
							, dc.getIdClazz(), period.getId());
					
					List<Data> features = list.stream().map(f -> {
						return new FeatureVO(f.getLoi(), f.getLoiname(), f.getAreas());
					}).collect(Collectors.toList());	
							
					periods.add(new PeriodVO(period.getStartDate(), period.getEndDate(), features));
				});
				datas.add(new DataVO(data.getName(), dc.getClazzName(), periods));
			});
		});
		
		datas.forEach(d -> {
			try {
				writable.write(d, DATA + d.getClazz().toLowerCase(), d.getName().replaceAll(" ", "_").toLowerCase());
			} catch (Exception e) {
				logger.error("Error: {}", e.getMessage());
			}			
		});
				
		logger.info("Finishing RedisDataFeeder: {}", LocalDateTime.now());
	}
	
	/**
	 * This service will post DATA_CLASS in REDIS by API
	 */	
	@Scheduled(cron = "0 3 * * * *")
	public void redisDataClassFeeder() {
		logger.info("Starting RedisDataClassFeeder: {}", LocalDateTime.now());
				
		dataService.findAll().forEach(data -> {
			List<Clazz> classes = new ArrayList<>();
			dataClassService.findAllByData(data).forEach(dataClass -> {								
				classes.add(dataClass.getClazz());				
			});
			
			try {
				writable.write(new DataClassVO(data, classes), DATA_LOI + "classes", data.getName().replaceAll(" ", "_").toLowerCase());
			} catch (Exception e) {
				logger.error("Error: {}", e.getMessage());
			}
		});
				
		logger.info("Finishing RedisDataClassFeeder: {}", LocalDateTime.now());
	}
	
	/**
	 * This service will post DATA_PERIODS in REDIS by API
	 */	
	@Scheduled(cron = "0 5 * * * *")
	public void redisDataPeriodFeeder() {
		logger.info("Starting RedisDataPeriodFeeder: {}", LocalDateTime.now());
				
		dataService.findAll().forEach(data -> {	
			List<Data> periods = periodService.findAllByData(data)
									.stream()
									.map(p -> {
										return new PeriodVO(p.getStartDate(), p.getStartDate());
									}).collect(Collectors.toList());
			try {
				writable.write(new DataPeriodVO(data, periods), DATA_LOI + "periods", data.getName().replaceAll(" ", "_").toLowerCase());
			} catch (Exception e) {
				logger.error("Error: {}", e.getMessage());
			}
		});
				
		logger.info("Finishing RedisDataPeriodFeeder: {}", LocalDateTime.now());
	}
	
	/**
	 * This service will post DATA_LOI in REDIS by API
	 */
	@Scheduled(cron = "0 7 * * * *")
	public void redisDataLoisFeeder() {
		logger.info("Starting RedisDataLoisFeeder: {}", LocalDateTime.now());
				
		dataService.findAll().forEach(data -> {						
			try {				
				writable.write(new DataLoisVO(
						data
						, loiVOService.findAllByData(data.getId())), DATA_LOI + "lois"
						, data.getName().replaceAll(" ", "_").toLowerCase());
			} catch (Exception e) {
				logger.error("Error: {}", e.getMessage());
			}
		});
				
		logger.info("Finishing RedisDataLoisFeeder: {}", LocalDateTime.now());
	}
	
	/**
	 * This service will post DATA_LOI_LOINAMES in REDIS by API
	 */
	@Scheduled(cron = "0 10 * * * *")
	public void redisDataLoiLoinamesFeeder() {
		logger.info("Starting RedisDataLoiLoinamesFeeder: {}", LocalDateTime.now());
				
		dataService.findAll().forEach(data -> {
			List<LoiVO> lois = new ArrayList<>();
			
			loiVOService.findAllByData(data.getId()).forEach(loi -> {					
				lois.add(new LoiVO(loi.getGid(), loi.getName(), loinamesVOService.findAllByLoi(loi.getGid(), data.getId())));
			});		
						
			try {
				writable.write(new DataLoiLoinamesVO(data, lois), DATA_LOI + "loinames", data.getName().replaceAll(" ", "_").toLowerCase());
			} catch (Exception e) {
				logger.error("Error: {}", e.getMessage());
			}
		});
				
		logger.info("Finishing RedisDataLoiLoinamesFeeder: {}", LocalDateTime.now());
	}
}
