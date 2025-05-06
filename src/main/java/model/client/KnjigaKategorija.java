package model.client;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import model.Kategorija;
import model.Knjiga;

@Entity
public class KnjigaKategorija {
	
	
	@Id
	@SequenceGenerator(name="knjigakategorijaSeq", sequenceName="knjigakategorija_id_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "knjigakategorijaSeq")
	private long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	Knjiga knjiga;
	
	@ManyToOne(cascade = CascadeType.ALL)
	Kategorija kategorija;

	public KnjigaKategorija() {
		super();
	}

	public KnjigaKategorija(Knjiga knjiga, Kategorija kategorija) {
		super();
		this.knjiga = knjiga;
		this.kategorija = kategorija;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Knjiga getKnjiga() {
		return knjiga;
	}

	public void setKnjiga(Knjiga knjiga) {
		this.knjiga = knjiga;
	}

	public Kategorija getKategorija() {
		return kategorija;
	}

	public void setKategorija(Kategorija kategorija) {
		this.kategorija = kategorija;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((kategorija == null) ? 0 : kategorija.hashCode());
		result = prime * result + ((knjiga == null) ? 0 : knjiga.hashCode());
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
		KnjigaKategorija other = (KnjigaKategorija) obj;
		if (id != other.id) {
			return false;
		}
		if (kategorija == null) {
			if (other.kategorija != null) {
				return false;
			}
		} else if (!kategorija.equals(other.kategorija)) {
			return false;
		}
		if (knjiga == null) {
			if (other.knjiga != null) {
				return false;
			}
		} else if (!knjiga.equals(other.knjiga)) {
			return false;
		}
		return true;
	}

	
	
	

}
