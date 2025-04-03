package repository;

import java.util.HashSet;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import model.Iznajmljivanje;
import model.Knjiga;
import model.Zaposlen;

@Dependent
public class IznajmljivanjeRepository {
	
		@Inject
		EntityManager em;
		
		@Transactional
		public Iznajmljivanje addIznajmljivanje(Iznajmljivanje i) {
			return em.merge(i);
		}
		
		@Transactional
		public List<Iznajmljivanje> getAllIznajmljivanja(){
			
			List<Iznajmljivanje> iznajmljivanja = em.createNamedQuery(Iznajmljivanje.GET_ALL_IZNAJMLJIVANJA, Iznajmljivanje.class).getResultList();
			
			for (Iznajmljivanje iznajmljivanje : iznajmljivanja) {
				List<Zaposlen> zaposleni = em.createNamedQuery(Zaposlen.GET_ZAPOSLENI_FOR_IZDAVANJE, Zaposlen.class).setParameter("id", iznajmljivanje.getId()).getResultList();
			
				iznajmljivanje.setZaposleni(new HashSet<>(zaposleni));
			}
			
			return iznajmljivanja;
		}
	}



