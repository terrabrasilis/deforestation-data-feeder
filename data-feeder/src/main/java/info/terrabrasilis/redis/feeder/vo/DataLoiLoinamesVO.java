package info.terrabrasilis.redis.feeder.vo;

import java.io.Serializable;
import java.util.List;

import info.terrabrasilis.redis.feeder.domain.Data;

/**
 * 
 * @author jether
 *
 */
public final class DataLoiLoinamesVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3505053332629270889L;
	
	private final Data data;
	private final List<LoiVO> lois;
	
	public DataLoiLoinamesVO(Data data, List<LoiVO> lois) {
		this.data = data;
		this.lois = lois;
	}
        
        public static final DataLoiLoinamesVO of(Data data, List<LoiVO> lois) {
            return new DataLoiLoinamesVO(data, lois);
        }

	public Data getData() {
		return data;
	}

	public List<LoiVO> getLois() {
		return lois;
	}

}
