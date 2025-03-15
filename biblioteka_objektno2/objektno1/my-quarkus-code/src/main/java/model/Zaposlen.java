package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Zaposlen {

	  @Id
	  long id;
	  String ime;
	  String prezime;
	  String brojTelefona;
	
	  
	  
	  
	  public Zaposlen() {
		super();
	  }
	  
	  
	  
}
