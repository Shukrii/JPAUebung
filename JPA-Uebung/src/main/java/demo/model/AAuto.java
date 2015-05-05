package demo.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the a_auto database table.
 * 
 */
@Entity
@Table(name="a_auto")
@NamedQuery(name="AAuto.findAll", query="SELECT a FROM AAuto a")
public class AAuto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="a_id")
	private int aId;

	@Column(name="a_fahrzeugtyp")
	private String aFahrzeugtyp;

	@Column(name="a_kilometerstand")
	private String aKilometerstand;

	@Column(name="a_marke")
	private String aMarke;

	@Column(name="a_pferdestaerke")
	private String aPferdestaerke;

	@Column(name="a_zustand")
	private String aZustand;

	//bi-directional many-to-one association to AuAutohaus
	@ManyToOne
	@JoinColumn(name="a_au_id")
	private AuAutohaus auAutohaus;

	public AAuto() {
	}

	public int getAId() {
		return this.aId;
	}

	public void setAId(int aId) {
		this.aId = aId;
	}

	public String getAFahrzeugtyp() {
		return this.aFahrzeugtyp;
	}

	public void setAFahrzeugtyp(String aFahrzeugtyp) {
		this.aFahrzeugtyp = aFahrzeugtyp;
	}

	public String getAKilometerstand() {
		return this.aKilometerstand;
	}

	public void setAKilometerstand(String aKilometerstand) {
		this.aKilometerstand = aKilometerstand;
	}

	public String getAMarke() {
		return this.aMarke;
	}

	public void setAMarke(String aMarke) {
		this.aMarke = aMarke;
	}

	public String getAPferdestaerke() {
		return this.aPferdestaerke;
	}

	public void setAPferdestaerke(String aPferdestaerke) {
		this.aPferdestaerke = aPferdestaerke;
	}

	public String getAZustand() {
		return this.aZustand;
	}

	public void setAZustand(String aZustand) {
		this.aZustand = aZustand;
	}

	public AuAutohaus getAuAutohaus() {
		return this.auAutohaus;
	}

	public void setAuAutohaus(AuAutohaus auAutohaus) {
		this.auAutohaus = auAutohaus;
	}

}