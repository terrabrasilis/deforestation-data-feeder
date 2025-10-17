package info.terrabrasilis.redis.feeder.interfaces;

import java.io.Closeable;
import java.io.IOException;

/**
 * 
 * @author jether
 *
 */
public interface Writable extends Closeable {
	public default void write(String key, Object obj) throws Exception {
		
	};
	
	public default void write(Object obj, String host) throws Exception {
		
	};
	
	public default void write(Object obj, String host, String header) throws Exception {
		
	};

	public default void write(Object obj, String host, String header, boolean useGson) throws Exception {
		
	};

	@Override
	public default void close() throws IOException {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}
