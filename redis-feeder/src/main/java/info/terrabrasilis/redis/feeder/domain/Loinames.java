package info.terrabrasilis.redis.feeder.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author jether
 *
 */
@Entity
@Table(name="loinames")
public class Loinames implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 716014733701522739L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gid")
	private Integer gid;

	@Column(name = "name")
	private String name;

	@Column(name = "codibge")
	private String codibge;
	
	public Integer getGid() {
		return gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCodibge() {
		return codibge;
	}

	public void setCodibge(String codibge) {
		this.codibge = codibge;
	}

}
