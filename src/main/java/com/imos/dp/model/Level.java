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
public class Level implements Serializable {
	
	@Getter
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private Long id;
	
	@Getter @Setter
	@Column(name="LEVEL_NAME", nullable=false, unique=true)
	private String levelName;
	
	@Getter @Setter
	@Column(name="MAX_COUNT", nullable=false)
	private Integer maxCount;
	
	@Getter @Setter
	@Column(name="PENALTY_COUNT", nullable=false)
	private Integer penaltyCount;
	
	@Getter @Setter
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
