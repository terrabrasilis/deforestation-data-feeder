package info.terrabrasilis.redis.feeder.vo;

import java.io.Serializable;

import info.terrabrasilis.redis.feeder.interfaces.Data;

/**
 * 
 * @author jether
 *
 */
public final class LoinamesVO implements Data, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5804518619057707906L;
	
	private Integer gid;
	private String loiname;
	private Double area;
	
	/**
	 * @param gid
	 * @param loiname
	 */
	public LoinamesVO(Integer gid, String loiname) {
		super();
		this.gid = gid;
		this.loiname = loiname;
	}

	/**
	 * @param loiname
	 * @param area
	 */
	public LoinamesVO(String loiname, Double area) {
		super();
		this.loiname = loiname;
		this.area = area;
	}

	public String getLoiname() {
		return loiname;
	}

	public Double getArea() {
		return area;
	}

	public Integer getGid() {
		return gid;
	}
	
}
