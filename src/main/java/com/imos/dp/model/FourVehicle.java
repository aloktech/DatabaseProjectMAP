/**
 * 
 */
package com.imos.dp.model;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Pintu
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Entity
//@DiscriminatorValue(value="Car")
public class FourVehicle extends Vehicle {

	private String stringleWheel;
	
	/**
	 * 
	 */
	public FourVehicle() {
		// TODO Auto-generated constructor stub
	}

}
