package model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Clan {
	
	@Id
	@SequenceGenerator(name="clanSeq", sequenceName="clan_id_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "clanSeq")
	Long id;
    String ime;
	String prezime;
	String email;
    Date datumClanstva;
   
   
    
    
    public Clan(String ime, String prezime, String email, Date datumClanstva) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.datumClanstva = datumClanstva;
	}







	public Clan() {
		super();
	}







	public Long getId() {
		return id;
	}







	public void setId(Long id) {
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







	public String getEmail() {
		return email;
	}







	public void setEmail(String email) {
		this.email = email;
	}







	public Date getDatumClanstva() {
		return datumClanstva;
	}







	public void setDatumClanstva(Date datumClanstva) {
		this.datumClanstva = datumClanstva;
	}







	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datumClanstva == null) ? 0 : datumClanstva.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Clan other = (Clan) obj;
		if (datumClanstva == null) {
			if (other.datumClanstva != null) {
				return false;
			}
		} else if (!datumClanstva.equals(other.datumClanstva)) {
			return false;
		}
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
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
		return "Clan [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", email=" + email + ", datumClanstva="
				+ datumClanstva + "]";
	}


	
    
	
    
    
    
    
	

}
