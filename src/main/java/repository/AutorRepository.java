package repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import model.Autor;


@Dependent
public class AutorRepository {
	
	@Inject
	EntityManager em;
	
	@Transactional
	public Autor addAutor(Autor a) {
		return em.merge(a);
	}
	
	@Transactional
	public List<Autor> getAll(){
		return em.createQuery("SELECT a FROM Autor a", Autor.class).getResultList();
	}

}
