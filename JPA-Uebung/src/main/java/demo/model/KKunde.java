package demo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the k_kunde database table.
 * 
 */
@Entity
@Table(name="k_kunde")
@NamedQuery(name="KKunde.findAll", query="SELECT k FROM KKunde k")
public class KKunde implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="k_id")
	private int kId;

	@Column(name="k_adresse")
	private String kAdresse;

	private String k_berechtigteKlassen;

	@Temporal(TemporalType.DATE)
	@Column(name="k_gedbat")
	private Date kGedbat;

	@Column(name="k_name")
	private String kName;

	//bi-directional many-to-one association to MMitglied
	@OneToMany(mappedBy="KKunde")
	private List<MMitglied> MMitglieds;

	public KKunde() {
	}

	public int getKId() {
		return this.kId;
	}

	public void setKId(int kId) {
		this.kId = kId;
	}

	public String getKAdresse() {
		return this.kAdresse;
	}

	public void setKAdresse(String kAdresse) {
		this.kAdresse = kAdresse;
	}

	public String getK_berechtigteKlassen() {
		return this.k_berechtigteKlassen;
	}

	public void setK_berechtigteKlassen(String k_berechtigteKlassen) {
		this.k_berechtigteKlassen = k_berechtigteKlassen;
	}

	public Date getKGedbat() {
		return this.kGedbat;
	}

	public void setKGedbat(Date kGedbat) {
		this.kGedbat = kGedbat;
	}

	public String getKName() {
		return this.kName;
	}

	public void setKName(String kName) {
		this.kName = kName;
	}

	public List<MMitglied> getMMitglieds() {
		return this.MMitglieds;
	}

	public void setMMitglieds(List<MMitglied> MMitglieds) {
		this.MMitglieds = MMitglieds;
	}

	public MMitglied addMMitglied(MMitglied MMitglied) {
		getMMitglieds().add(MMitglied);
		MMitglied.setKKunde(this);

		return MMitglied;
	}

	public MMitglied removeMMitglied(MMitglied MMitglied) {
		getMMitglieds().remove(MMitglied);
		MMitglied.setKKunde(null);

		return MMitglied;
	}

}