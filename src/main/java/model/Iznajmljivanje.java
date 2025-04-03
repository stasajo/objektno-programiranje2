package model;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
@NamedQuery(name = Iznajmljivanje.GET_ALL_IZNAJMLJIVANJA, query = "SELECT i FROM Iznajmljivanje i")
public class Iznajmljivanje {
	
	public static final String GET_ALL_IZNAJMLJIVANJA = "Izajmljivanje.getAllIznajmljivanja";
	
	@Id
	@SequenceGenerator(name="iznajmljivanjeSeq", sequenceName="iznajmljivanje_id_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "iznajmljivanjeSeq")
	long id;
	Date datum_iznajmljivanja;
	Date datum_vracanja;
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "zaposlen_id")
	Set<Zaposlen> zaposleni;
	
	
	
	
	public Iznajmljivanje(Date datum_iznajmljivanja, Date datum_vracanja) {
		super();
		this.datum_iznajmljivanja = datum_iznajmljivanja;
		this.datum_vracanja = datum_vracanja;
	}


	public Iznajmljivanje() {
		super();
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Date getDatum_iznajmljivanja() {
		return datum_iznajmljivanja;
	}


	public void setDatum_iznajmljivanja(Date datum_iznajmljivanja) {
		this.datum_iznajmljivanja = datum_iznajmljivanja;
	}


	public Date getDatum_vracanja() {
		return datum_vracanja;
	}


	public void setDatum_vracanja(Date datum_vracanja) {
		this.datum_vracanja = datum_vracanja;
	}

	
	

	public Set<Zaposlen> getZaposleni() {
		return zaposleni;
	}


	public void setZaposleni(Set<Zaposlen> zaposleni) {
		this.zaposleni = zaposleni;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datum_iznajmljivanja == null) ? 0 : datum_iznajmljivanja.hashCode());
		result = prime * result + ((datum_vracanja == null) ? 0 : datum_vracanja.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Iznajmljivanje other = (Iznajmljivanje) obj;
		if (datum_iznajmljivanja == null) {
			if (other.datum_iznajmljivanja != null) {
				return false;
			}
		} else if (!datum_iznajmljivanja.equals(other.datum_iznajmljivanja)) {
			return false;
		}
		if (datum_vracanja == null) {
			if (other.datum_vracanja != null) {
				return false;
			}
		} else if (!datum_vracanja.equals(other.datum_vracanja)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		return true;
	}


	@Override
	public String toString() {
		return "Iznajmljivanje [id=" + id + ", datum_iznajmljivanja=" + datum_iznajmljivanja + ", datum_vracanja="
				+ datum_vracanja + "]";
	}



	
	
	
	
	
	

}
