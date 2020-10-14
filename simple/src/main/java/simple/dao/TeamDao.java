package simple.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import simple.srv.CoderAllSrv;

public class TeamDao {

	private static final Logger LOG = LoggerFactory.getLogger(CoderAllSrv.class);

	public List<Team> getAll() {
		EntityManager em = null;

		try {
			em = HibUtil.getEntityManager();
			String jpql = "SELECT c FROM Team c";
			return em.createQuery(jpql, Team.class).getResultList();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public Optional<Team> get(Integer id) {
		EntityManager em = null;

		try {
			em = HibUtil.getEntityManager();
			return Optional.ofNullable(em.find(Team.class, id));
		} finally {
			em.close();
		}
	}

	public boolean create(Team newTeam) {
		EntityManager em = null;

		try {
			LOG.trace("enter");
			em = HibUtil.getEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(newTeam);
			et.commit();
			return true;
		} catch (Exception ex) {
			LOG.warn("Can't persist entity", ex);
			return false;
		} finally {
			em.close();
		}
	}

	public List<Team> getAllLazy() {
		return getAll();
	}

	public Optional<Team> getEager(int id) {
		EntityManager em = null;

		try {
			em = HibUtil.getEntityManager();
			String jpql = "SELECT e FROM Teams2 e JOIN FETCH e.coders WHERE e.id = " + id;
			List<Team> teams = em.createQuery(jpql, Team.class).getResultList();
			return teams.isEmpty() ? Optional.empty() : Optional.of(teams.get(0));
		} finally {
			em.close();
		}
	}

	public List<Team> getAllEager() {
		EntityManager em = null;

		try {
			em = HibUtil.getEntityManager();
			String jpql = "SELECT DISTINCT e FROM Teams2 e JOIN FETCH e.coders";
			return em.createQuery(jpql, Team.class).getResultList();
		} finally {
			em.close();
		}
	}

}
