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
	
	private Data data;
	private List<Clazz> classes;
	
	public DataClassVO(Data data, List<Clazz> classes) {
		this.data = data;
		this.classes = classes;
	}

	public Data getData() {
		return data;
	}

	public List<Clazz> getClasses() {
		return classes;
	}
	
}
