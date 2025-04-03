package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;

@Entity
@NamedQuery(name = Zaposlen.GET_ZAPOSLENI_FOR_IZDAVANJE, query = "SELECT z FROM Zaposlen z WHERE z.iznajmljivanje.id = :id")

public class Zaposlen {

	public static final String GET_ZAPOSLENI_FOR_IZDAVANJE = "Zaposlen.getZaposleniForIzdavanje";
	
	
	  @Id
	  @SequenceGenerator(name="zaposlenSeq", sequenceName="zaposlen_id_seq", allocationSize = 1, initialValue = 1)
	  @GeneratedValue(generator = "zaposlenSeq")
	  long id;
	  String ime;
	  String prezime;
	  String brojTelefona;
	
	  @ManyToOne
	  private Iznajmljivanje iznajmljivanje;
	  
	  public Zaposlen(String ime, String prezime, String brojTelefona) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.brojTelefona = brojTelefona;
	}




	public Zaposlen() {
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




	public String getBrojTelefona() {
		return brojTelefona;
	}




	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	
	



	public Iznajmljivanje getIznajmljivanje() {
		return iznajmljivanje;
	}




	public void setIznajmljivanje(Iznajmljivanje iznajmljivanje) {
		this.iznajmljivanje = iznajmljivanje;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brojTelefona == null) ? 0 : brojTelefona.hashCode());
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
		Zaposlen other = (Zaposlen) obj;
		if (brojTelefona == null) {
			if (other.brojTelefona != null) {
				return false;
			}
		} else if (!brojTelefona.equals(other.brojTelefona)) {
			return false;
		}
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
		return "Zaposlen [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", brojTelefona=" + brojTelefona + "]";
	}
	  
	  
	
	
	  
}
