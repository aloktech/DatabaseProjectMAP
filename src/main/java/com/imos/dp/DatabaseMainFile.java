package com.imos.dp;

import com.imos.dp.model.User;
import com.imos.dp.services.UserServices;

/**
 * @author Pintu
 *
 */
public class DatabaseMainFile {
	
	public DatabaseMainFile() {
		
		UserServices userService = new UserServices();
		
		User user = new User();
		user.setFirstName("Alok22");
		user.setLastName("Meher233");
		
		//userService.addNewUser(user);
		
		user = new User();
		user.setFirstName("Alok24");
		user.setLastName("Meher233");
		
		//userService.addNewUser(user);
		
		user = userService.getUserById(1L);
		System.out.println(user.getFirstName());
		
		System.out.println(userService.getUser().size());
		
		userService.close();
		
	}
	
	public static void main(String[] args) {

		new DatabaseMainFile();
	}
}
