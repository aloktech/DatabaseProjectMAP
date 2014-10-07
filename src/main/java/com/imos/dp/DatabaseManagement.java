/**
 * 
 */
package com.imos.dp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.google.inject.Inject;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.Transactional;
import com.imos.dp.model.Level;
import com.imos.dp.model.Vehicle;

/**
 * @author Pintu
 *
 */
public class DatabaseManagement {

	@Inject
	private EntityManager em;

	private PersistService service;

	@Inject
	public DatabaseManagement(PersistService service) {
		this.service = service;
		this.service.start();
	}

	@Transactional
	void saveVehicle(Vehicle vehicle) {
		try {
			em.persist(vehicle);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * 
	 * @param level
	 */
	@Transactional
	public void addLevel(Level level) {
		try {
			em.persist(level);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	protected void finalize() throws Throwable {
		em.close();
		this.service.stop();
		super.finalize();
	}

	@Transactional
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
