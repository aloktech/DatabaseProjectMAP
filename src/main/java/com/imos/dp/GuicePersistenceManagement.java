/**
 * 
 */
package com.imos.dp;

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
public class GuicePersistenceManagement {

	@Inject
	private EntityManager em;

	private PersistService service;

	@Inject
	public GuicePersistenceManagement(PersistService service) {
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

	void close() {
		this.service.stop();
	}
}
