package info.terrabrasilis.redis.feeder.vo;

import java.io.Serializable;
import java.util.List;

import info.terrabrasilis.redis.feeder.interfaces.Data;

/**
 * 
 * @author jether
 *
 */
public final class ClazzVO implements Data, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1806065554169678990L;
	
	private String clazz;
	private List<Data> periods;
	
	/**
	 * @param clazz
	 * @param periods
	 */
	public ClazzVO(String clazz, List<Data> periods) {
		super();
		this.clazz = clazz;
		this.periods = periods;
	}

	public String getClazz() {
		return clazz;
	}

	public List<Data> getPeriods() {
		return periods;
	}
		
}
