package demo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the au_autohaus database table.
 * 
 */
@Entity
@Table(name="au_autohaus")
@NamedQuery(name="AuAutohaus.findAll", query="SELECT a FROM AuAutohaus a")
public class AuAutohaus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="au_id")
	private int auId;

	@Column(name="au_abstellplatz")
	private int auAbstellplatz;

	@Column(name="au_adresse")
	private String auAdresse;

	@Column(name="au_name")
	private String auName;

	@Column(name="au_ort")
	private String auOrt;

	//bi-directional many-to-one association to AAuto
	@OneToMany(mappedBy="auAutohaus")
	private List<AAuto> AAutos;

	//bi-directional many-to-one association to MMitglied
	@OneToMany(mappedBy="auAutohaus")
	private List<MMitglied> MMitglieds;

	public AuAutohaus() {
	}

	public int getAuId() {
		return this.auId;
	}

	public void setAuId(int auId) {
		this.auId = auId;
	}

	public int getAuAbstellplatz() {
		return this.auAbstellplatz;
	}

	public void setAuAbstellplatz(int auAbstellplatz) {
		this.auAbstellplatz = auAbstellplatz;
	}

	public String getAuAdresse() {
		return this.auAdresse;
	}

	public void setAuAdresse(String auAdresse) {
		this.auAdresse = auAdresse;
	}

	public String getAuName() {
		return this.auName;
	}

	public void setAuName(String auName) {
		this.auName = auName;
	}

	public String getAuOrt() {
		return this.auOrt;
	}

	public void setAuOrt(String auOrt) {
		this.auOrt = auOrt;
	}

	public List<AAuto> getAAutos() {
		return this.AAutos;
	}

	public void setAAutos(List<AAuto> AAutos) {
		this.AAutos = AAutos;
	}

	public AAuto addAAuto(AAuto AAuto) {
		getAAutos().add(AAuto);
		AAuto.setAuAutohaus(this);

		return AAuto;
	}

	public AAuto removeAAuto(AAuto AAuto) {
		getAAutos().remove(AAuto);
		AAuto.setAuAutohaus(null);

		return AAuto;
	}

	public List<MMitglied> getMMitglieds() {
		return this.MMitglieds;
	}

	public void setMMitglieds(List<MMitglied> MMitglieds) {
		this.MMitglieds = MMitglieds;
	}

	public MMitglied addMMitglied(MMitglied MMitglied) {
		getMMitglieds().add(MMitglied);
		MMitglied.setAuAutohaus(this);

		return MMitglied;
	}

	public MMitglied removeMMitglied(MMitglied MMitglied) {
		getMMitglieds().remove(MMitglied);
		MMitglied.setAuAutohaus(null);

		return MMitglied;
	}

}