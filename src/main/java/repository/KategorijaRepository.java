package repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import model.Kategorija;

@Dependent
public class KategorijaRepository {

	@Inject
	EntityManager em;
	
	@Transactional
	public Kategorija addKategorija(Kategorija k) {
		return em.merge(k);
	}
	
	@Transactional
	public List<Kategorija> getAll(){
		return em.createQuery("SELECT k FROM Kategorija k", Kategorija.class).getResultList();
		
	}	
	
}
	
	
	
