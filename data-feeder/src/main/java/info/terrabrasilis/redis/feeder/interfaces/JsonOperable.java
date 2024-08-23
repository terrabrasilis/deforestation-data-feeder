package info.terrabrasilis.redis.feeder.interfaces;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author jether
 *
 * @param <T>
 */
public interface JsonOperable<T> extends Serializable {

	String convertTToJSON(final T t);
	
	String convertListOfTToJSON(final List<T> list);	
}
