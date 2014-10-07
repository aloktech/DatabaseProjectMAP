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
//@DiscriminatorValue(value="Bike")
public class TwoVehicle extends Vehicle {

	private String stringleHandle;
	/**
	 * 
	 */
	public TwoVehicle() {
		// TODO Auto-generated constructor stub
	}

}
