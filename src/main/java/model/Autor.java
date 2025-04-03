package model;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Autor {
	
	
	@Id
	@SequenceGenerator(name="autorSeq", sequenceName="autor_id_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "autorSeq")
	long id;
	String ime;
	String prezime;

	
	
	
	public Autor(String ime, String prezime) {
		super();
		this.ime = ime;
		this.prezime = prezime;
	
	}


	public Autor() {
		super();
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getIme() {
		return ime;
	}


	public void setIme(String ime) {
		this.ime = ime;
	}


	public String getPrezime() {
		return prezime;
	}


	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((ime == null) ? 0 : ime.hashCode());
		result = prime * result + ((prezime == null) ? 0 : prezime.hashCode());
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
		Autor other = (Autor) obj;
		if (id != other.id) {
			return false;
		}
		if (ime == null) {
			if (other.ime != null) {
				return false;
			}
		} else if (!ime.equals(other.ime)) {
			return false;
		}
		if (prezime == null) {
			if (other.prezime != null) {
				return false;
			}
		} else if (!prezime.equals(other.prezime)) {
			return false;
		}
		return true;
	}


	@Override
	public String toString() {
		return "Autor [id=" + id + ", ime=" + ime + ", prezime=" + prezime + "]";
	}


	
	
	
	

}
