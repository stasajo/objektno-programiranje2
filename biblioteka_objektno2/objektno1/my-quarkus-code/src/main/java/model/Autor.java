package model;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Autor {
	
	
	@Id
	long id;
	String ime;
	String prezime;
	@ElementCollection
	List<Knjiga> knjige;
	
	
	public Autor() {
		super();
	}
	
	
	
	

}
