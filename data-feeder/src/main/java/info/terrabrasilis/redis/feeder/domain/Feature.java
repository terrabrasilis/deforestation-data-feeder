package info.terrabrasilis.redis.feeder.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="features")
public class Feature implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3608622855285582875L;
	
	@Id
	@Column(name = "gid_polygon")
	private String gidPolygon;
	
	@Column(name = "created_at")
	private LocalDate created;
		
	@Column(name="area_km2")
	private Double area = 0.0;

	@ManyToOne
	@JoinColumn(name="id_period")
	private Period period;
	
	@ManyToOne
	@JoinColumn(name="id_data_class")
	private DataClazz dataClazz;
	
	@ManyToOne
	@JoinColumn(name="id_data_loi_loinames")
	private DataLoiLoinames dataLoiLoinames;
	
	public String getGidPolygon() {
		return gidPolygon;
	}

	public void setGidPolygon(String gidPolygon) {
		this.gidPolygon = gidPolygon;
	}

	public LocalDate getCreated() {
		return created;
	}

	public void setCreated(LocalDate created) {
		this.created = created;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	public DataClazz getDataClazz() {
		return dataClazz;
	}

	public void setDataClazz(DataClazz dataClazz) {
		this.dataClazz = dataClazz;
	}

	public DataLoiLoinames getDataLoiLoinames() {
		return dataLoiLoinames;
	}

	public void setDataLoiLoinames(DataLoiLoinames dataLoiLoinames) {
		this.dataLoiLoinames = dataLoiLoinames;
	}
	
}
