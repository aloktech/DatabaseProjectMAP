/**
 * 
 */
package com.imos.dp.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


/**
 * @author Pintu
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="dp_user")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Getter
@Setter
public class User implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private Long id;
	
	@Column(name="CRT_DATE")
	private Date creationDate;
	
	@Column(name="MOD_DATE")
	private Date modifiedDate;
	
	@Column(name="MOD_BY")
	private Long modifiedBy;
	
	@Column(name="FIRST_NAME", length=16, nullable=false)
	private String firstName;
	
	@Column(name="MIDDLE_NAME", length=16)
	private String middleName;
	
	@Column(name="LAST_NAME", length=16, nullable=false)
	private String lastName;
	
	@Column(name="DATE_OF_BIRTH")
	private Date dateOfBirth;

	/*@Embedded
	private OfficeDetail officeDetail;
	
	@OneToMany(targetEntity=UserProcessDetail.class, mappedBy="user")
	private Set<UserProcessDetail> processDetails = new HashSet<>();*/
	
	
}

