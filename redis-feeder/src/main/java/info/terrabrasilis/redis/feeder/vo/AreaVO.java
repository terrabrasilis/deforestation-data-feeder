package info.terrabrasilis.redis.feeder.vo;

import java.io.Serializable;

/**
 * 
 * @author jether
 *
 */
public final class AreaVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 683143137611584496L;

	private Integer type;
	private Double area;

	public AreaVO(Integer type, Double area) {
		super();
		this.type = type;
		this.area = area;
	}

	public Integer getType() {
		return type;
	}

	public Double getArea() {
		return area;
	}

}
