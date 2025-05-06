package model;



import java.util.Set;

import com.fasterxml.jackson.core.sym.Name;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;


@Entity
@NamedQueries({
	@NamedQuery(name = Knjiga.GET_ALL_KNJIGE, query = "SELECT k FROM Knjiga k"),
	@NamedQuery(name = Knjiga.GET_KNJIGE_BY_NAME, query = "Select k from Knjiga k where k.naziv = :name")
	
})



public class Knjiga {
	
	
	public static final String GET_ALL_KNJIGE = "Knjiga.getAllKnjige";
	public static final String GET_KNJIGE_BY_NAME = "Knjiga.getKnjigeByName"; 
	
	
	@Id
	@SequenceGenerator(name="knjigaSeq", sequenceName="knjiga_id_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "knjigaSeq")
	private long id;
	String naziv;
	int godina_izdanja;
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "izdavac_id")
	Set<Izdavac> izdavaci;
	
	
	
	public Knjiga() {
		super();
	}



	public Knjiga(long id, String naziv, int godina_izdanja, Set<Izdavac> izdavaci) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.godina_izdanja = godina_izdanja;
		this.izdavaci = izdavaci;
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



	public int getGodina_izdanja() {
		return godina_izdanja;
	}



	public void setGodina_izdanja(int godina_izdanja) {
		this.godina_izdanja = godina_izdanja;
	}

	
	



	public Set<Izdavac> getIzdavaci() {
		return izdavaci;
	}



	public void setIzdavaci(Set<Izdavac> izdavaci) {
		this.izdavaci = izdavaci;
	}

	
	
	
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + godina_izdanja;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((izdavaci == null) ? 0 : izdavaci.hashCode());
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
		Knjiga other = (Knjiga) obj;
		if (godina_izdanja != other.godina_izdanja) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (izdavaci == null) {
			if (other.izdavaci != null) {
				return false;
			}
		} else if (!izdavaci.equals(other.izdavaci)) {
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
		return "Knjiga [id=" + id + ", naziv=" + naziv + ", godina_izdanja=" + godina_izdanja + "]";
	}



	
	
	
	
	
	
	

}
