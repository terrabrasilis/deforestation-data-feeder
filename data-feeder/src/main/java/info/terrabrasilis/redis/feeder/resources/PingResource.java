package info.terrabrasilis.redis.feeder.resources;

import static info.terrabrasilis.redis.feeder.util.ApiVersionUtil.*;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import info.terrabrasilis.redis.feeder.response.PingResponse;
import reactor.core.publisher.Flux;

/**
 * 
 * @author jether
 *
 */

@CrossOrigin(allowCredentials="true", value="*")
@RestController
@RequestMapping(value = { 
		ROOT_PATH_V1 + PING
})
public class PingResource {
	
	@GetMapping
	public Flux<ResponseEntity<PingResponse>> ping() {
		return Flux.just(new ResponseEntity<PingResponse>(
				new PingResponse(LocalDateTime.now(), "I'm alive!"),
				HttpStatus.OK));
	}
	
	@GetMapping(path = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<ResponseEntity<PingResponse>> streamPing() {
		return Flux.just(new ResponseEntity<PingResponse>(
				new PingResponse(LocalDateTime.now(), "I'm alive!"),
				HttpStatus.OK));
	}
}
