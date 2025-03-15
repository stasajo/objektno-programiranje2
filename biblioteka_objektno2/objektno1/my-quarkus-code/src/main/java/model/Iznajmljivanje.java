package model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Iznajmljivanje {
	
	@Id
	long id;
	Date datum_iznajmljivanja;
	Date datum_vracanja;
	
	
	public Iznajmljivanje() {
		super();
	}
	
	
	

}
