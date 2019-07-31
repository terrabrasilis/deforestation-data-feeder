package info.terrabrasilis.redis.feeder.interfaces;

/**
 * 
 * @author jether
 *
 */
public interface Writable {
	public default void write(String key, Object obj) throws Exception {
		
	};
	
	public default void write(Object obj, String host) throws Exception {
		
	};
	
	public default void write(Object obj, String host, String header) throws Exception {
		
	};
}
