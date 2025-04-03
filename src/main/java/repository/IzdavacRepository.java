package repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import model.Izdavac;


@Dependent
public class IzdavacRepository {
	
	@Inject
	EntityManager em;
	
	
	@Transactional
	public Izdavac addIzdavac(Izdavac i) {
		return em.merge(i);
	}
	
	@Transactional
	public List<Izdavac> getAll(){
		return em.createQuery("SELECT i FROM Izdavac i", Izdavac.class).getResultList();
	}
	
	
	

}
