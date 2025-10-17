package info.terrabrasilis.redis.feeder.util;

import java.io.Serializable;

/**
 * 
 * @author jether
 *
 */
public class ApiVersionUtil implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5098798014868231794L;
	/**
	 * The basic configuration
	 */
	public final static String REST_API = "api/";
	public final static String VERSION_V1 = "v1/";	
	
	/**
	 * root path
	 */
	public final static String REDIS_FEEDER = "redis-feeder/";
	
	/**
	 * complete root path
	 */
	public final static String ROOT_PATH_V1 = REST_API + VERSION_V1 + REDIS_FEEDER;
	
	/**
	 * The specific paths
	 */	
	public final static String PING = "ping";
}
