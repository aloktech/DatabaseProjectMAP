package com.imos.dp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.imos.dp.model.Level;

/**
 * @author Pintu
 *
 */
public class DatabaseMainFile {
	
	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("SampleDB");
	
	public DatabaseMainFile() {
		
		Level level = new Level();
		level.setLevelName("Level 4");
		level.setMaxCount(10);
		level.setPenaltyCount(0);
		level.setMaxErrorCount(0);
		addLevel(level);
		
		level = new Level();
		level.setLevelName("Level 3");
		level.setMaxCount(25);
		level.setPenaltyCount(2);
		level.setMaxErrorCount(25);
		addLevel(level);
		
		level = new Level();
		level.setLevelName("Level 2");
		level.setMaxCount(5);
		level.setPenaltyCount(0);
		level.setMaxErrorCount(0);
		addLevel(level);
		
		level = new Level();
		level.setLevelName("Certified");
		level.setMaxCount(0);
		level.setPenaltyCount(0);
		level.setMaxErrorCount(0);
		addLevel(level);
		
		findAllLevel();
		findAllLevelSize();
		
		updateLevelStatus();
		
		findAllLevel();
		
		emf.close();
	}
	/**
	 * 
	 */
	private void updateLevelStatus() {
		Level level = null;
		EntityManager em = emf.createEntityManager();
		try {
			Query query = em.createQuery("from Level l where l.levelName = :levelName");
			query.setParameter("levelName", "Level 3");
			level = (Level) query.getSingleResult();
			level.setMaxCount(35);
			
			EntityTransaction tran = em.getTransaction();
			try {
				tran = em.getTransaction();
				tran.begin();
				
				em.merge(level);
				
				tran.commit();
			} catch(Exception e) {
				tran.rollback();
				System.out.println(e.getMessage());
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			em.close();
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		new DatabaseMainFile();
		
	}

	/**
	 * 
	 */
	private void findAllLevelSize() {
		EntityManager em = emf.createEntityManager();
		
		System.out.println(em.createQuery("from Level l").getResultList().size());
		
		em.close();
	}
	
	/**
	 * 
	 */
	private void findAllLevel() {
		EntityManager em = emf.createEntityManager();
		
		@SuppressWarnings("unchecked")
		List<Level> list = em.createQuery("from Level l").getResultList();
		for (Level l : list) {
			System.out.println(l);
		}
		
		em.close();
	}
	
	/**
	 * 
	 * @param level
	 */
	private void addLevel(Level level) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tran = null;
		try {
			tran = em.getTransaction();
			tran.begin();
			
			em.persist(level);
			
			tran.commit();
		} catch (Exception e) {
			tran.rollback();
			System.out.println(e.getMessage());
		} finally {
			em.close();
		}
	}

}
