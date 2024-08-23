package info.terrabrasilis.redis.feeder.vo;

import java.io.Serializable;
import java.util.List;

import info.terrabrasilis.redis.feeder.domain.Clazz;
import info.terrabrasilis.redis.feeder.domain.Data;

/**
 * 
 * @author jether
 *
 */
public final class DataClassVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3505053332629270889L;
	
	private final Data data;
	private final List<Clazz> classes;
	
	private DataClassVO(Data data, List<Clazz> classes) {
		this.data = data;
		this.classes = classes;
	}
        
        public static final DataClassVO of(Data data, List<Clazz> classes) {
            return new DataClassVO(data, classes);
        }

	public Data getData() {
		return data;
	}

	public List<Clazz> getClasses() {
		return classes;
	}
	
}
