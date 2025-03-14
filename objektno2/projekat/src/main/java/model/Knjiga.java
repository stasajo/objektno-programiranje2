package model;

import java.util.List;

public class Knjiga {
	
	
	private String id;
	private String naziv;
	private int godina_izdanja;
	private List<Autor> autori;
	private Izdavac izdavac;
	private List<Kategorija> kategorije;
	private List<Iznajmljivanje> iznajmljivanja;
	
	
	
	
	public Knjiga(String id, String naziv, int godina_izdanja, List<Autor> autori, Izdavac izdavac,
			List<Kategorija> kategorije, List<Iznajmljivanje> iznajmljivanja) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.godina_izdanja = godina_izdanja;
		this.autori = autori;
		this.izdavac = izdavac;
		this.kategorije = kategorije;
		this.iznajmljivanja = iznajmljivanja;
	}




	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




	public String getNaziv() {
		return naziv;
	}




	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}




	public int getGodina_izdanja() {
		return godina_izdanja;
	}




	public void setGodina_izdanja(int godina_izdanja) {
		this.godina_izdanja = godina_izdanja;
	}




	public List<Autor> getAutori() {
		return autori;
	}




	public void setAutori(List<Autor> autori) {
		this.autori = autori;
	}




	public Izdavac getIzdavac() {
		return izdavac;
	}




	public void setIzdavac(Izdavac izdavac) {
		this.izdavac = izdavac;
	}




	public List<Kategorija> getKategorije() {
		return kategorije;
	}




	public void setKategorije(List<Kategorija> kategorije) {
		this.kategorije = kategorije;
	}




	public List<Iznajmljivanje> getIznajmljivanja() {
		return iznajmljivanja;
	}




	public void setIznajmljivanja(List<Iznajmljivanje> iznajmljivanja) {
		this.iznajmljivanja = iznajmljivanja;
	} 

	
	
	
	



}
