package com.imos.dp;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.imos.dp.model.FourVehicle;
import com.imos.dp.model.Level;
import com.imos.dp.model.TwoVehicle;
import com.imos.dp.model.Vehicle;

/**
 * @author Pintu
 *
 */
public class DatabaseMainFile {

	public DatabaseMainFile() {
		Injector injector = Guice.createInjector(new JpaPersistModule("SampleDB"));
		
		DatabaseManagement dm = injector.getInstance(DatabaseManagement.class);
		
		Vehicle vehicle = new Vehicle();
		vehicle.setName("Vehicle");
		dm.saveVehicle(vehicle);
		
		TwoVehicle bike = new TwoVehicle();
		bike.setName("Bike");
		bike.setStringleHandle("Bike Handle");
		dm.saveVehicle(bike);
		
		FourVehicle car = new FourVehicle();
		car.setName("Car");
		car.setStringleWheel("Car Wheel");
		dm.saveVehicle(car);
		
		dm.close();
		
		//caseOne(dm);

		//findAllLevel();
		//findAllLevelSize();

		//updateLevelStatusOne();

		//findAllLevel();

		//emf.close();
	}


	/**
	 * @param dm
	 */
	private void caseOne(DatabaseManagement dm) {
		Level level = new Level();
		level.setLevelName("Level 5");
		level.setMaxCount(10);
		level.setPenaltyCount(0);
		level.setMaxErrorCount(0);
		dm.addLevel(level);

		level = new Level();
		level.setLevelName("Level 6");
		level.setMaxCount(25);
		level.setPenaltyCount(2);
		level.setMaxErrorCount(25);
		dm.addLevel(level);

		level = new Level();
		level.setLevelName("Level 7");
		level.setMaxCount(5);
		level.setPenaltyCount(0);
		level.setMaxErrorCount(0);
		dm.addLevel(level);

		level = new Level();
		level.setLevelName("Certified II");
		level.setMaxCount(0);
		level.setPenaltyCount(0);
		level.setMaxErrorCount(0);
		dm.addLevel(level);
	}
	
	
	public static void main(String[] args) {

		new DatabaseMainFile();
		
	}
}
