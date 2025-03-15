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
	private String naziv;
	private int godina_izdanja;
	
	@ElementCollection
	private List<Autor> autori;
	@ManyToOne
	private Izdavac izdavac;
	@ElementCollection
	private List<Kategorija> kategorije;
	@ElementCollection
	private List<Iznajmljivanje> iznajmljivanja;
	
	
	
	public Knjiga() {
		super();
	}
	
	
	

}
