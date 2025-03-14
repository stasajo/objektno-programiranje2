package model;

import java.util.List;

public class Autor {

	private String id;
	private String ime;
	private String prezime;
	private List<Knjiga> knjige;
	
	
	public Autor(String id, String ime, String prezime, List<Knjiga> knjige) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.knjige = knjige;
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


	public List<Knjiga> getKnjige() {
		return knjige;
	}


	public void setKnjige(List<Knjiga> knjige) {
		this.knjige = knjige;
	}
}
