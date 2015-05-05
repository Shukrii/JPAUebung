package demo.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the m_mitglied database table.
 * 
 */
@Embeddable
public class MMitgliedPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="m_au_id", insertable=false, updatable=false)
	private int mAuId;

	@Column(name="m_k_id", insertable=false, updatable=false)
	private int mKId;

	public MMitgliedPK() {
	}
	public int getMAuId() {
		return this.mAuId;
	}
	public void setMAuId(int mAuId) {
		this.mAuId = mAuId;
	}
	public int getMKId() {
		return this.mKId;
	}
	public void setMKId(int mKId) {
		this.mKId = mKId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MMitgliedPK)) {
			return false;
		}
		MMitgliedPK castOther = (MMitgliedPK)other;
		return 
			(this.mAuId == castOther.mAuId)
			&& (this.mKId == castOther.mKId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.mAuId;
		hash = hash * prime + this.mKId;
		
		return hash;
	}
}