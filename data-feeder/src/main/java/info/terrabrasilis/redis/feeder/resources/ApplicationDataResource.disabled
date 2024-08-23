package info.terrabrasilis.redis.feeder.resources;

import static info.terrabrasilis.redis.feeder.util.ApiVersionUtil.ROOT_PATH_V1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import info.terrabrasilis.redis.feeder.interfaces.Data;
import info.terrabrasilis.redis.feeder.service.ApplicationDataService;
/**
 * 
 * @author jether
 *
 */
@CrossOrigin(allowCredentials="true", value="*")
@RestController
@RequestMapping(value = { 
		ROOT_PATH_V1 + "application"
})
public class ApplicationDataResource {
	
	@Autowired
	private ApplicationDataService applicationDataService;

	/**
	 * @param applicationDataService
	 */
	public ApplicationDataResource(ApplicationDataService applicationDataService) {
		this.applicationDataService = applicationDataService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Data>> getAll() {
		return new ResponseEntity<List<Data>>(this.applicationDataService.findAll(), HttpStatus.OK); 
	}
	
	@GetMapping("{identifier}/app")
	public ResponseEntity<Data> getByIdentifier(@PathVariable(name="identifier") String identifier) {
		return new ResponseEntity<Data>(this.applicationDataService.find(identifier).get(), HttpStatus.OK); 
	}
}
