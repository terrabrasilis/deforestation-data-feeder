package info.terrabrasilis.redis.feeder.vo;

import java.io.Serializable;

import info.terrabrasilis.redis.feeder.interfaces.Data;

/**
 * 
 * @author jether
 *
 */
public final class FeatureFilterVO implements Data, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3190335038259204910L;
	
	private final Integer loi;
	private final Integer loiname;
	private final AreaVO[] areas;
	
	private FeatureFilterVO(Integer loi, Integer loiname, AreaVO... areas) {
		super();
		this.loi = loi;
		this.loiname = loiname;
		this.areas = areas;
	}
        
        public static final FeatureFilterVO of(Integer loi, Integer loiname, AreaVO... areas) {
            return new FeatureFilterVO(loi, loiname, areas);
        }

	public Integer getLoi() {
		return loi;
	}

	public Integer getLoiname() {
		return loiname;
	}

	public AreaVO[] getAreas() {
		return areas;
	}
	
}
