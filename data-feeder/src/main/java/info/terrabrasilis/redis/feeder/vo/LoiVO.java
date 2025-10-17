package info.terrabrasilis.redis.feeder.vo;

import java.io.Serializable;
import java.util.List;

import info.terrabrasilis.redis.feeder.interfaces.Data;

/**
 * 
 * @author jether
 *
 */
public final class LoiVO implements Data, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6856573995718568082L;

	private Integer gid;
	private String name;
	private List<Data> loinames;

	
	/**
	 * @param gid
	 * @param name
	 */
	private LoiVO(Integer gid, String name) {
		super();
		this.gid = gid;
		this.name = name;
	}

	/**
	 * @param name
	 * @param loinames
	 */
	private LoiVO(String name, List<Data> loinames) {
		super();
		this.name = name;
		this.loinames = loinames;
	}
	
	/**
	 * 
	 * @param gid
	 * @param name
	 * @param loinames
	 */
	private LoiVO(Integer gid, String name, List<Data> loinames) {
		this(gid, name);
		this.loinames = loinames;
	}
        
        public static final LoiVO of(Integer gid, String name, List<Data> loinames) {
            return new LoiVO(gid, name, loinames);
        }

	public String getName() {
		return name;
	}

	public List<Data> getLoinames() {
		return loinames;
	}

	public Integer getGid() {
		return gid;
	}

}
