package info.terrabrasilis.redis.feeder.vo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import info.terrabrasilis.redis.feeder.interfaces.Data;

/**
 * 
 * @author jether
 *
 */
public final class PeriodVO implements Data, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3340462553232530494L;

	private final LocalDate startDate;
	private final LocalDate endDate;
	private List<Data> features;

	/**
	 * 
	 * @param startDate
	 * @param endDate
	 */
	private PeriodVO(LocalDate startDate, LocalDate endDate) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
	}

	/**
	 * @param startDate
	 * @param endDate
         * @param features
	 */
	private PeriodVO(LocalDate startDate, LocalDate endDate, List<Data> features) {
		this(startDate, endDate);
		this.features = features;
	}
        
        public static final PeriodVO of(LocalDate startDate, LocalDate endDate, List<Data> features) {
            return new PeriodVO(startDate, endDate, features);
        }

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public List<Data> getFeatures() {
		return features;
	}

}
