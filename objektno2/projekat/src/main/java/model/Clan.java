package model;

import java.sql.Date;
import java.util.List;



public class Clan {
	private String id;
	private String ime;
	private String prezime;
	private String email;
	private Date datumClanstva;
	private List<Iznajmljivanje> iznajmljivanja;
	
	
	public Clan(String id, String ime, String prezime, String email, Date datumClanstva,
			List<Iznajmljivanje> iznajmljivanja) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.datumClanstva = datumClanstva;
		this.iznajmljivanja = iznajmljivanja;
	}


	public Clan() {
		// TODO Auto-generated constructor stub
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getIme() {
		return ime;
	}


	public void setIme(String ime) {
		this.ime = ime;
	}


	public String getPrezime() {
		return prezime;
	}


	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getDatumClanstva() {
		return datumClanstva;
	}


	public void setDatumClanstva(Date datumClanstva) {
		this.datumClanstva = datumClanstva;
	}


	public List<Iznajmljivanje> getIznajmljivanja() {
		return iznajmljivanja;
	}


	public void setIznajmljivanja(List<Iznajmljivanje> iznajmljivanja) {
		this.iznajmljivanja = iznajmljivanja;
	}
	
	

}
