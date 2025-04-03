package model;

import java.util.List;

import org.hibernate.query.sqm.FetchClauseType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;

@Entity
@NamedQuery(name = Izdavac.GET_IZDAVACI_FOR_KNJIGA, query = "SELECT i FROM Izdavac i WHERE i.knjiga.id = :id")
public class Izdavac {
	
	
	public static final String GET_IZDAVACI_FOR_KNJIGA = "Izdavac.getIzdavaciForKnjiga";
	
	
	 @Id
	 @SequenceGenerator(name="izdavacSeq", sequenceName="izdavac_id_seq", allocationSize = 1, initialValue = 1)
	 @GeneratedValue(generator = "izdavacSeq")
	 long id;
	 String ime;
	 String zemljaPorijekla;
	 
	 @ManyToOne
	 private Knjiga knjiga;


	public Izdavac() {
		super();
	}

	public Izdavac(long id,String ime, String zemljaPorijekla) {
		super();
		this.id = id;
		this.ime = ime;
		this.zemljaPorijekla = zemljaPorijekla;
		
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

	public String getZemljaPorijekla() {
		return zemljaPorijekla;
	}

	public void setZemljaPorijekla(String zemljaPorijekla) {
		this.zemljaPorijekla = zemljaPorijekla;
	}

	

	public Knjiga getKnjiga() {
		return knjiga;
	}

	public void setKnjiga(Knjiga knjiga) {
		this.knjiga = knjiga;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((ime == null) ? 0 : ime.hashCode());
		result = prime * result + ((knjiga == null) ? 0 : knjiga.hashCode());
		result = prime * result + ((zemljaPorijekla == null) ? 0 : zemljaPorijekla.hashCode());
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
		Izdavac other = (Izdavac) obj;
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
		if (knjiga == null) {
			if (other.knjiga != null) {
				return false;
			}
		} else if (!knjiga.equals(other.knjiga)) {
			return false;
		}
		if (zemljaPorijekla == null) {
			if (other.zemljaPorijekla != null) {
				return false;
			}
		} else if (!zemljaPorijekla.equals(other.zemljaPorijekla)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Izdavac [id=" + id + ", ime=" + ime + ", zemljaPorijekla=" + zemljaPorijekla + "]";
	}
	
	
	 

}
