package model;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Kategorija {
	
	@Id
    long id;
    String naziv;
    @ElementCollection
    List<Knjiga> knjige;
	
    
    
    public Kategorija() {
		super();
	}
    
    
    

}
