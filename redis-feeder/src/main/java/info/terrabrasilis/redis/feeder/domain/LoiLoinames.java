package info.terrabrasilis.redis.feeder.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author jether
 *
 */
@Entity
@Table(name="loi_loinames")
public class LoiLoinames implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4778321548951515773L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="id_loi")
	private Loi loi;
	
	@ManyToOne
	@JoinColumn(name="gid_loinames")
	private Loinames loinames;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Loi getLoi() {
		return loi;
	}

	public void setLoi(Loi loi) {
		this.loi = loi;
	}

	public Loinames getLoinames() {
		return loinames;
	}

	public void setLoinames(Loinames loinames) {
		this.loinames = loinames;
	}
	
}
