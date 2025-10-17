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
@Table(name="data_loi_loinames")
public class DataLoiLoinames implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2163850735656966400L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="id_data")
	private Data data;
	
	@ManyToOne
	@JoinColumn(name="id_loi_loinames")
	private LoiLoinames loiLoinames;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public LoiLoinames getLoiLoinames() {
		return loiLoinames;
	}

	public void setLoiLoinames(LoiLoinames loiLoinames) {
		this.loiLoinames = loiLoinames;
	}	
	
	public Loi getLoi() {
		return this.loiLoinames.getLoi();
	}
	
	public Loinames getLoinames() {
		return this.loiLoinames.getLoinames();
	}
}
