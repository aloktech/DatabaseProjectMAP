/**
 * 
 */
package com.imos.dp.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.imos.dp.hibernate.HibernateServices;
import com.imos.dp.model.User;

/**
 * @author Pintu
 *
 */
public class UserServices {
	
	private HibernateServices<User> hibernateService = new HibernateServices<>();
	
	public void addNewUser() {
		User user = new User();
		user.setFirstName("Alok22");
		user.setLastName("Meher233");
		
		hibernateService.save(user);
	}
	
	public void addNewUser(User user) {
		
		hibernateService.save(user);
	}
	
	public User getUserById(Long id) {
		return hibernateService.findById(User.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getUser() {
		StringBuffer sb = new StringBuffer();
		sb.append("from User u where u.id = :userId");
		
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("userId", 1L);
		boolean status = false;
		if (status) {
			sb.append(" and u.firstName = :firstName");
			map.put("firstName", "Alok25");
		}
		
		return hibernateService.getList(sb.toString(), map);
	}
	
	public void close() {
		hibernateService.close();
	}
}
