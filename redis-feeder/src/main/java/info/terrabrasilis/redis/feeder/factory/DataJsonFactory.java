package info.terrabrasilis.redis.feeder.factory;

import java.util.List;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import info.terrabrasilis.redis.feeder.interfaces.Data;
import info.terrabrasilis.redis.feeder.interfaces.JsonOperable;


/**
 * 
 * @author jether
 *
 */
@Component
public final class DataJsonFactory implements JsonOperable<Data> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7239839870981951318L;
	
	@Override
	public String convertTToJSON(final Data applicationData) {
		return new Gson().toJson(applicationData);
	}
	
	@Override
	public String convertListOfTToJSON(List<Data> applications) {
		return new Gson().toJson(applications);
	}	
}
