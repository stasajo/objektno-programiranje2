package model;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class Knjiga {
	
	
	@Id
	long id;
	 String naziv;
	 int godina_izdanja;
	
	@ElementCollection
	 List<Autor> autori;
	@ManyToOne
	 Izdavac izdavac;
	@ElementCollection
	 List<Kategorija> kategorije;
	@ElementCollection
	 List<Iznajmljivanje> iznajmljivanja;
	
	
	
	public Knjiga() {
		super();
	}
	
	
	

}
