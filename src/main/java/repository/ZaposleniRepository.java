package repository;

import java.util.List;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import model.Zaposlen;

@Dependent
public class ZaposleniRepository {
	
	
	@Inject
	EntityManager em;
	
	@Transactional
	public Zaposlen addZaposlen(Zaposlen z) {
		return em.merge(z);
	}
	
	@Transactional
	public List<Zaposlen> getAll(){
		return em.createQuery("SELECT z FROM Zaposlen z", Zaposlen.class).getResultList();
		
	}
	
	

}
