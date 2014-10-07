/**
 * 
 */
package com.imos.dp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import lombok.Data;

import com.imos.dp.model.Level;
import com.imos.dp.model.Vehicle;

/**
 * @author Pintu
 *
 */
@Data
public class DatabaseManagement {

	private EntityManager em = Persistence.createEntityManagerFactory("SampleDB").createEntityManager();


	void saveVehicle(Vehicle vehicle) {
		try {
			em.getTransaction().begin();
			em.persist(vehicle);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * 
	 * @param level
	 */
	public void addLevel(Level level) {
		try {
			em.getTransaction().begin();
			em.persist(level);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void updateLevelStatus() {
		Level level = null;
		try {
			Query query = em.createQuery("from Level l where l.levelName = :levelName");
			query.setParameter("levelName", "Level 3");
			level = (Level) query.getSingleResult();
			level.setMaxCount(35);

			em.merge(level);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 
	 */
	private void findAllLevelSize() {

		System.out.println(em.createQuery("from Level l").getResultList().size());
	}

	/**
	 * 
	 */
	private void findAllLevel() {

		@SuppressWarnings("unchecked")
		List<Level> list = em.createQuery("from Level l").getResultList();
		for (Level l : list) {
			System.out.println(l);
		}
	}
	
	void close() {
		em.getEntityManagerFactory().close();
	}
}
