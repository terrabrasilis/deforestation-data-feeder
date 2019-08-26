package info.terrabrasilis.redis.feeder.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author jether
 *
 */
@XmlRootElement
public final class ResponseMessage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5397453337965259072L;
	
	private int code;
	private String message;
	
	public ResponseMessage(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
