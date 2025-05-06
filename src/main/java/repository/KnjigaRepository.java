package repository;

import java.util.HashSet;
import java.util.List;

import exception.KnjigaException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import model.Izdavac;
import model.Knjiga;
import model.client.KnjigaKategorija;

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
	
	public List<Knjiga> getKnjigeByName(String name) throws KnjigaException{
		
		List<Knjiga> knjige = em.createNamedQuery(Knjiga.GET_KNJIGE_BY_NAME, Knjiga.class).setParameter("name", name).getResultList();
		
		if(knjige.size() == 0) {
			throw new KnjigaException("Ne postoje takve knjige.");
		}
		return knjige;
	}
	
	
	
	@Transactional
	public KnjigaKategorija createKnjigaKategorija(KnjigaKategorija kk) {
		return em.merge(kk);
	}

}
