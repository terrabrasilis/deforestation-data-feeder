package info.terrabrasilis.redis.feeder.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import info.terrabrasilis.redis.feeder.interfaces.Data;

/**
 * 
 * @author jether
 *
 */
public final class FeatureVO implements Data, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3705371968764723429L;

	private final Integer loi;
	private final Integer loiname;
	private final List<AreaVO> areas = new ArrayList<>();

	private FeatureVO(Integer loi, Integer loiname, AreaVO... areas) {
		super();
		this.loi = loi;
		this.loiname = loiname;

		this.addAreasToAreasList(areas);
	}
        
        public static final FeatureVO of(Integer loi, Integer loiname, AreaVO... areas) {
            return new FeatureVO(loi, loiname, areas);
        }

	public Integer getLoi() {
		return loi;
	}

	public Integer getLoiname() {
		return loiname;
	}

	public List<AreaVO> getAreas() {
		return areas;
	}

	private void addAreasToAreasList(AreaVO[] areas) {

		for (AreaVO area : areas) {
			this.areas.add(area);
		}
	}
}
