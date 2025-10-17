package info.terrabrasilis.redis.feeder.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import info.terrabrasilis.redis.feeder.domain.Application;
import info.terrabrasilis.redis.feeder.interfaces.Data;

/**
 * 
 * @author jether
 *
 */
public final class ApplicationData implements Serializable, Data {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2906497868098836850L;
	
	private String identifier;
	private String name;
	private String created;
	private String uuid;
	
	public ApplicationData() {}

	public ApplicationData(Application application) {	
		this.identifier = application.getIdentifier();
		this.name = application.getName();
		this.uuid = application.getUuid();
		convertDateTimeToString(application.getCreated());
	}

	public String getIdentifier() {
		return this.identifier;
	}

	public String getName() {
		return this.name;
	}
		
	public String getCreated() {
		return this.created;
	}

	public String getUuid() {
		return this.uuid;
	}

	private void convertDateTimeToString(LocalDateTime dateTime) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		
		if(!isNull(dateTime)) {
			this.created = dateTime.format(formatter);			
		}		
	}
	
	private boolean isNull(Object object) {
		boolean isNull = false;
		if (object == null) {
			isNull = true;
		}
		return isNull;
	}
	
	public List<ApplicationData> convertJSONToListOfT(String json) {
		return new Gson().fromJson(json, new TypeToken<List<ApplicationData>>(){}.getType());
	}
}
