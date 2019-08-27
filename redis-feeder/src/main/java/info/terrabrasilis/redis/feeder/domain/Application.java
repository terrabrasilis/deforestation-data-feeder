package info.terrabrasilis.redis.feeder.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

/**
 * 
 * @author jether
 *
 */
@Entity
@Table(name = "application")
public class Application implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7880059262212493036L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "identifier")
	private String identifier;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "uuid")
	private String uuid;
	
	@Column(name = "created")
	private LocalDateTime created;
	
	@Column(name = "updated")
	private LocalDateTime updated;
	
	public Application() {}

	/**
	 * @param identifier
	 * @param name
	 * @param uuid
	 * @param created
	 * @param updated
	 */
	public Application(String identifier, String name, String uuid, LocalDateTime created, LocalDateTime updated) {
		this.identifier = identifier;
		this.name = name;
		this.uuid = uuid;
		this.created = created;
		this.updated = updated;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return this.id;
	}

	public String getIdentifier() {
		return this.identifier;
	}

	public String getName() {
		return this.name;
	}

	public String getUuid() {
		return this.uuid;
	}

	public LocalDateTime getCreated() {
		return this.created;
	}

	public LocalDateTime getUpdated() {
		return this.updated;
	}
}
