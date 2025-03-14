package model;

import java.sql.Date;

public class Iznajmljivanje {
	private String id;
	private Date datum_iznajmljivanja;
	private Date datum_vracanja;
	
	
	public Iznajmljivanje(String id, Date datum_iznajmljivanja, Date datum_vracanja) {
		super();
		this.id = id;
		this.datum_iznajmljivanja = datum_iznajmljivanja;
		this.datum_vracanja = datum_vracanja;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getDatum_iznajmljivanja() {
		return datum_iznajmljivanja;
	}
	public void setDatum_iznajmljivanja(Date datum_iznajmljivanja) {
		this.datum_iznajmljivanja = datum_iznajmljivanja;
	}
	public Date getDatum_vracanja() {
		return datum_vracanja;
	}
	public void setDatum_vracanja(Date datum_vracanja) {
		this.datum_vracanja = datum_vracanja;
	}
	
}
