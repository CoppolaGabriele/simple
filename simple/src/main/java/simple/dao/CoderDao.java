package simple.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;


public class CoderDao {
	
	public List<Coder> getAll() {
		EntityManager em = null;

		try {
			em = HibUtil.getEntityManager();
			String jpql = "SELECT c FROM Coders2 c";
			return em.createQuery(jpql, Coder.class).getResultList();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}
	
    public Optional<Coder> read(Integer id) {
        EntityManager em = null;

        try {
            em = HibUtil.getEntityManager();
            return Optional.ofNullable(em.find(Coder.class, id));
        } finally {
            em.close();
        }
    }
}
