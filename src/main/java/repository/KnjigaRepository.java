package repository;

import java.util.HashSet;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import model.Izdavac;
import model.Knjiga;

@Dependent
public class KnjigaRepository {
	
	@Inject
	EntityManager em;
	
	
	@Transactional
	public Knjiga addKnjiga(Knjiga k) {
		
		return em.merge(k);
	}
	
	
	@Transactional
	public List<Knjiga> getAllKnjige(){
		
		List<Knjiga> knjige = em.createNamedQuery(Knjiga.GET_ALL_KNJIGE,Knjiga.class).getResultList();
		
		for (Knjiga knjiga : knjige) {
			List<Izdavac> izdavaci = em.createNamedQuery(Izdavac.GET_IZDAVACI_FOR_KNJIGA, Izdavac.class).setParameter("id", knjiga.getId()).getResultList();
			
			knjiga.setIzdavaci(new HashSet<>(izdavaci));
		}
		
		return knjige;
	}
	

}
