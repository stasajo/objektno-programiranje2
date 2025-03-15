package repository;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import model.Clan;

public class ClanRepository {

	@Inject
	EntityManager em;
	
	public Clan addClan(Clan c) {
		return em.merge(c);
	}
}
