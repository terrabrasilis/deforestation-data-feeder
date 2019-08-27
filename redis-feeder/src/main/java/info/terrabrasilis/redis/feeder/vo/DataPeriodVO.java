package info.terrabrasilis.redis.feeder.vo;

import java.io.Serializable;
import java.util.List;

import info.terrabrasilis.redis.feeder.domain.Data;

/**
 * 
 * @author jether
 */
public final class DataPeriodVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3151466459624630469L;

	private Data data;
	private List<info.terrabrasilis.redis.feeder.interfaces.Data> periods;

	/**
	 * 
	 * @param data
         * @param periods
	 */
	private DataPeriodVO(Data data, List<info.terrabrasilis.redis.feeder.interfaces.Data> periods) {
		super();
		this.data = data;
		this.periods = periods;
	}
        
        public static final DataPeriodVO of(Data data, List<info.terrabrasilis.redis.feeder.interfaces.Data> periods) {
            return new DataPeriodVO(data, periods);
        }

	public Data getData() {
		return data;
	}

	public List<info.terrabrasilis.redis.feeder.interfaces.Data> getPeriods() {
		return periods;
	}

}
