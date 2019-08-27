package info.terrabrasilis.redis.feeder.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import info.terrabrasilis.redis.feeder.response.PingResponse;
import static info.terrabrasilis.redis.feeder.util.ApiVersionUtil.*;


/**
 * 
 * @author jether
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RedisFeederHealthyCheck {
	@Autowired
	private WebTestClient webTestClient;
	
	@Test
	public void testPingFromAPI() {
		webTestClient.get().uri(ROOT_PATH_V1 + PING)
	        .accept(MediaType.APPLICATION_JSON_UTF8)
	        .exchange()
	        .expectStatus().isOk()
	        .expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
	        .expectBodyList(PingResponse.class);
	}

}
