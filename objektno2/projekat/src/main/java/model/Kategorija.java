package model;

import java.util.List;

public class Kategorija {

	private String id;
    private String naziv;
    private List<Knjiga> knjige;
	
    
    public Kategorija(String id, String naziv, List<Knjiga> knjige) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.knjige = knjige;
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


	public List<Knjiga> getKnjige() {
		return knjige;
	}


	public void setKnjige(List<Knjiga> knjige) {
		this.knjige = knjige;
	}
    
}
