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

	private LocalDate startDate;
	private LocalDate endDate;
	private List<Data> features;

	/**
	 * 
	 * @param startDate
	 * @param endDate
	 */
	public PeriodVO(LocalDate startDate, LocalDate endDate) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
	}

	/**
	 * @param startDate
	 * @param endDate
	 * @param lois
	 */
	public PeriodVO(LocalDate startDate, LocalDate endDate, List<Data> features) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.features = features;
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
