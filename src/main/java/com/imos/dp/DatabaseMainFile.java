package com.imos.dp;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.imos.dp.model.FourVehicle;
import com.imos.dp.model.TwoVehicle;
import com.imos.dp.model.User;
import com.imos.dp.model.Vehicle;
import com.imos.dp.services.UserServices;

/**
 * @author Pintu
 *
 */
public class DatabaseMainFile {
	
	public DatabaseMainFile() {
		
		/*learningJPA();
		
		learningGuiceJPA();
		
		learningHibernate();*/
	}

	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private void learningJPA() {
		JPAManagement jpamgmt = new JPAManagement();
		
		Vehicle vehicle = new Vehicle();
		vehicle.setName("Vehicle");
		jpamgmt.saveVehicle(vehicle);
		
		TwoVehicle twoVehicle = new TwoVehicle();
		twoVehicle.setName("Bike");
		jpamgmt.saveVehicle(twoVehicle);
		
		FourVehicle fourVehicle = new FourVehicle();
		fourVehicle.setName("Car");
		jpamgmt.saveVehicle(fourVehicle);
		
		jpamgmt.close();
	}

	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private void learningGuiceJPA() {
		Injector injector = Guice.createInjector(new JpaPersistModule("SampleDB"));
		GuicePersistenceManagement gpm = injector.getInstance(GuicePersistenceManagement.class);
		
		Vehicle vehicle = injector.getInstance(Vehicle.class);
		vehicle.setName("Vehicle");
		gpm.saveVehicle(vehicle);
		
		TwoVehicle twoVehicle = injector.getInstance(TwoVehicle.class);
		twoVehicle.setName("Bike");
		gpm.saveVehicle(twoVehicle);
		
		FourVehicle fourVehicle = injector.getInstance(FourVehicle.class);
		fourVehicle.setName("Car");
		gpm.saveVehicle(fourVehicle);
		
		System.out.println(gpm.getClass().getName());
		
		gpm.close();
	}

	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private void learningHibernate() {
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
