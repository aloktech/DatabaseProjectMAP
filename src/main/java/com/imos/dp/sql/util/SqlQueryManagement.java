/**
 * 
 */
package com.imos.dp.sql.util;

import java.util.Date;


/**
 * @author Pintu
 *
 */
public class SqlQueryManagement {
	
	private StringBuffer sb = new StringBuffer();
	
	public void addQuery(String query) {
		sb.append(" ");
		sb.append(query);
		sb.append(" ");
	}
	
	public void addStringParameter(String query) {
		sb.append(" '");
		sb.append(query.trim());
		sb.append("' ");
	}
	
	public void addDateParameter(Date date) {
		sb.append(" ");
		sb.append(new java.sql.Date(date.getTime()));
		sb.append(" ");
	}
}
