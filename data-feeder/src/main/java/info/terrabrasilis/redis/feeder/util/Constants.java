package info.terrabrasilis.redis.feeder.util;

import java.io.Serializable;

/**
 * 
 * @author jether
 *
 */
public final class Constants implements Serializable {

	private static final long serialVersionUID = -8752276783418832709L;
	
	//private static final String HOST = System.getProperty("API_NODE_HOST");
    private static final String HOST = (System.getenv("HOST_REDIS_API")!=null)?(System.getenv("HOST_REDIS_API")):("http://192.168.15.43:3000");
	//private static final String HOST = "";// used to write JSON files to disk. See DataWriteJsonInDisk.java
	private static final String BASE_PATH = (System.getenv("JSON_BASE_PATH")!=null)?(System.getenv("JSON_BASE_PATH")):("/files");

	/**
	 * The location used to store json files
	 */
	public static final String JSON_BASE_PATH = BASE_PATH;
	
	/**
	 * Key to post, in REDIS, the JSON of allowed applications
	 */
	public static final String APP_IDENTIFIER_KEY = "appsIdentifier";
	/**
	 * Endpoint to post applications
	 */
	public static final String CONFIG_APPS = HOST + "/dashboard/api/v1/redis-cli/apps/identifier";
	/**
	 * Endpoint to post CONFIG_URI
	 */
	public static final String CONFIG_URI = HOST + "/dashboard/api/v1/redis-cli/config/";
	public static final String CONFIG_PATH = "/config/";
	/**
	 * Endpoint to post DATA
	 */
	public static final String DATA = HOST + "/dashboard/api/v1/redis-cli/data/";
	public static final String DATA_PATH = "/data/";
}
