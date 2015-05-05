package demo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the m_mitglied database table.
 * 
 */
@Entity
@Table(name="m_mitglied")
@NamedQuery(name="MMitglied.findAll", query="SELECT m FROM MMitglied m")
public class MMitglied implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MMitgliedPK id;

	@Temporal(TemporalType.DATE)
	private Date m_mitgliedSeit;

	//bi-directional many-to-one association to AuAutohaus
	@ManyToOne
	@JoinColumn(name="m_au_id")
	private AuAutohaus auAutohaus;

	//bi-directional many-to-one association to KKunde
	@ManyToOne
	@JoinColumn(name="m_k_id")
	private KKunde KKunde;

	public MMitglied() {
	}

	public MMitgliedPK getId() {
		return this.id;
	}

	public void setId(MMitgliedPK id) {
		this.id = id;
	}

	public Date getM_mitgliedSeit() {
		return this.m_mitgliedSeit;
	}

	public void setM_mitgliedSeit(Date m_mitgliedSeit) {
		this.m_mitgliedSeit = m_mitgliedSeit;
	}

	public AuAutohaus getAuAutohaus() {
		return this.auAutohaus;
	}

	public void setAuAutohaus(AuAutohaus auAutohaus) {
		this.auAutohaus = auAutohaus;
	}

	public KKunde getKKunde() {
		return this.KKunde;
	}

	public void setKKunde(KKunde KKunde) {
		this.KKunde = KKunde;
	}

}