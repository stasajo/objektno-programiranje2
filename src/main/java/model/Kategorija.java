package model;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Kategorija {
	
	@Id
	@SequenceGenerator(name="kategorijaSeq", sequenceName="kategorija_id_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "kategorijaSeq")
    private long id;
	
    String naziv;
  
	
    
    
    public Kategorija() {
		super();
	}
    
    
    
	public Kategorija(String naziv) {
		super();
		this.naziv = naziv;
		
	}


	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getNaziv() {
		return naziv;
	}



	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Kategorija other = (Kategorija) obj;
		if (id != other.id) {
			return false;
		}
		if (naziv == null) {
			if (other.naziv != null) {
				return false;
			}
		} else if (!naziv.equals(other.naziv)) {
			return false;
		}
		return true;
	}



	@Override
	public String toString() {
		return "Kategorija [id=" + id + ", naziv=" + naziv + "]";
	}



    

}
