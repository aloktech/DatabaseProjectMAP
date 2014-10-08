/**
 * 
 */
package com.imos.dp.hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.extern.java.Log;

/**
 * @author Pintu
 *
 */
@Log
public class HibernateServices<T> extends AbstractHibernateServices {

	/**
	 * 
	 * @param query
	 * @param map
	 * @return
	 */
	@SuppressWarnings({ "unchecked" })
	public List<T> getList(String query, Map<String, Object> map) {
		List<T> list = new ArrayList<>();
		try {
			session = getSession();
			 list = session.createQuery(query).setProperties(map).list();
		} catch (Exception e) {
			log.warning(e.getMessage());
		} finally {
			close(session);
		}
		return list;
	}
	
	/**
	 * 
	 * @param query
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> getList(String query) {
		List<T> list = null;
		try {
			session = getSession();
			list = session.createQuery(query).list();
		} catch (Exception e) {
			log.warning(e.getMessage());
		} finally {
			close(session);
		}
		return list;
	}
	
	/**
	 * 
	 * @param cls
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T findById(Class<T> cls, Long id) {
		T object = null;
		try {
			beforeTransaction();
			object = (T) session.get(cls, id);
			afterTransaction();
		} catch (Exception e) {
			log.warning(e.getMessage());
		}
		return object;
	}

	/**
	 * 
	 * @param object
	 */
	public void save(T object) {
		try {
			beforeTransaction();
			session.saveOrUpdate(object);
			afterTransaction();
		} catch (Exception e) {
			log.warning(e.getMessage());
		}
	}
	
	public void close() {
		super.close();
	}
}
