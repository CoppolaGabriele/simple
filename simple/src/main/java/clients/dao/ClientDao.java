package clients.dao;

import java.util.List;

import javax.persistence.EntityManager;


public class ClientDao {

	public List<Client> getAll() {
		EntityManager em = null;

		try {
			em = HibUtil.getEntityManager();
			String jpql = "SELECT c FROM Client c";
			return em.createQuery(jpql, Client.class).getResultList();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

}
