/**
 * 
 */
package com.imos.dp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Pintu
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="dp_level")
@Getter @Setter
public class Level implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private Long id;
	
	@Column(name="LEVEL_NAME", nullable=false, unique=true)
	private String levelName;
	
	@Column(name="MAX_COUNT", nullable=false)
	private Integer maxCount;
	
	@Column(name="PENALTY_COUNT", nullable=false)
	private Integer penaltyCount;
	
	@Column(name="MAX_ERROR_COUNT", nullable=false)
	private Integer maxErrorCount;
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("levelName : ");
		sb.append(levelName);
		sb.append(" maxCount : ");
		sb.append(maxCount);
		sb.append(" penaltyCount : ");
		sb.append(penaltyCount);
		sb.append(" maxErrorCount : ");
		sb.append(maxErrorCount);
		return sb.toString();
	}
}
