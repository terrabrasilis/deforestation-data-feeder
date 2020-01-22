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
    private static final String HOST = "http://150.163.17.103:3000";
	//private static final String HOST = "";// used to write JSON files to disk. See DataWriteJsonInDisk.java
	
	/**
	 * Key to post, in REDIS, the JSON of allowed applications
	 */
	public static final String APP_IDENTIFIER_KEY = "appsIdentifier";
	/**
	 * Endpoint to post applications
	 */
	public static final String CONFIG_APPS = HOST + "/dashboard/api/v1/redis-cli/apps/identifier";
	/**
	 * Endpoint to post DATA_LOI
	 */
	public static final String DATA_LOI = HOST + "/dashboard/api/v1/redis-cli/config/";
	/**
	 * Endpoint to post DATA_LOINAMES
	 */
	public static final String DATA_LOINAMES = HOST + "/dashboard/api/v1/redis-cli/config/";
	/**
	 * Endpoint to post DATA
	 */
	public static final String DATA = HOST + "/dashboard/api/v1/redis-cli/data/";
        /**
	 * Endpoint to post DATA_FILTER
	 */
	public static final String DATA_FILTER = HOST + "/dashboard/api/v1/redis-cli/config/";
        /**
	 * Endpoint to post CONFIG
	 */
	public static final String CONFIG = HOST + "/dashboard/api/v1/redis-cli/config/";
}
