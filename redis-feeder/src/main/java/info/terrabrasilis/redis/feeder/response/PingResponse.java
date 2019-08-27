package info.terrabrasilis.redis.feeder.response;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * @author jether
 *
 */
public final class PingResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7741061714318761830L;
	
	private LocalDateTime time;
	private String message;
	
	public PingResponse() {}
	
	public PingResponse(final LocalDateTime time, final String message) {
		this.time = time;
		this.message = message;
	}
	
	public LocalDateTime getTime() {
		return time;
	}
	public String getMessage() {
		return message;
	}
}
