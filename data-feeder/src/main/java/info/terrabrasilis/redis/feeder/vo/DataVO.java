package info.terrabrasilis.redis.feeder.vo;

import java.io.Serializable;
import java.util.List;

import com.google.gson.Gson;

import info.terrabrasilis.redis.feeder.interfaces.Data;

/**
 * 
 * @author jether
 *
 */
public final class DataVO implements Data, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6636610763934507921L;

	private String name;
	private String clazz;
	private List<Data> periods;
	
	/**
	 * 
	 * @param name
	 * @param periods
	 */
	private DataVO(String name, List<Data> periods) {
		super();
		this.name = name;
		this.periods = periods;
	}

	/**
	 * 
	 * @param name
	 * @param clazz
	 * @param periods
	 */
	private DataVO(String name, String clazz, List<Data> periods) {
                this(name, periods);
		this.clazz = clazz;
	}
        
        public static final DataVO of(String name, String clazz, List<Data> periods) {
            return new DataVO(name, clazz, periods);
        }

	public String getName() {
		return name;
	}

	public String getClazz() {
		return clazz;
	}

	public List<Data> getPeriods() {
		return periods;
	}
	
	@Override
	public String toString() {
		return new Gson().toJson(this) + "\n";
	}
}
