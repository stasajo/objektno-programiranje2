package model;

import java.util.List;

public class Izdavac {
	 private String id;
	 private String ime;
	 private String zemljaPorijekla;
	 private List<Knjiga> knjige;
	 
	 
	public Izdavac(String id, String ime, String zemljaPorijekla, List<Knjiga> knjige) {
		super();
		this.id = id;
		this.ime = ime;
		this.zemljaPorijekla = zemljaPorijekla;
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


	public String getZemljaPorijekla() {
		return zemljaPorijekla;
	}


	public void setZemljaPorijekla(String zemljaPorijekla) {
		this.zemljaPorijekla = zemljaPorijekla;
	}


	public List<Knjiga> getKnjige() {
		return knjige;
	}


	public void setKnjige(List<Knjiga> knjige) {
		this.knjige = knjige;
	}
	 

}
