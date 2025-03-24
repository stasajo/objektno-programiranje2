package model;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Izdavac {
	
	 @Id
	 long id;
	 String ime;
	 String zemljaPorijekla;
	 
	 @ElementCollection
	 List<Knjiga> knjige;

	public Izdavac() {
		super();
	}
	 
	 

}
