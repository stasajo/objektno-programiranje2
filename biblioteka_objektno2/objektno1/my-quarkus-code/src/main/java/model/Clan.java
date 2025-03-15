package model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Clan {
	
	@Id
	Long id;
    String ime;
	String prezime;
	String email;
    Date datumClanstva;
    @ElementCollection
    List<Iznajmljivanje> iznajmljivanja;
	
    
    
    public Clan() {
		super();
	}
    
    
    
    
	

}
