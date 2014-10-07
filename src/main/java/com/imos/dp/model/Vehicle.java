/**
 * 
 */
package com.imos.dp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Data;

/**
 * @author Pintu
 *
 */
@Data
@Entity
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Inheritance(strategy=InheritanceType.JOINED)
//@DiscriminatorColumn(name="VEHICLE_TYPE", discriminatorType=DiscriminatorType.STRING)
public class Vehicle {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private Long id;
	private String licenseNumber;
	private String name;
	
	/**
	 * 
	 */
	public Vehicle() {
		// TODO Auto-generated constructor stub
	}

}
