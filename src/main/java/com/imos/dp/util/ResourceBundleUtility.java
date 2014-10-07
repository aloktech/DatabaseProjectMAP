/**
 * 
 */
package com.imos.dp.util;

import java.util.Enumeration;
import java.util.ResourceBundle;

import lombok.Data;
import net.vidageek.mirror.dsl.Mirror;

/**
 * @author Pintu
 *
 */
@Data
public class ResourceBundleUtility {

	private final ResourceBundle MYSQL_RESOURCE_BUNDLE = ResourceBundle.getBundle("mysql");
	
	private final ResourceBundle HIBERNATE_RESOURCE_BUNDLE = ResourceBundle.getBundle("hibernate");
	
	public MysqlInfo populateMysqlResources(MysqlInfo mysql) {
		
		Mirror mirror = new Mirror();
		Enumeration<String> enu = MYSQL_RESOURCE_BUNDLE.getKeys();
		while (enu.hasMoreElements()) {
			String key = enu.nextElement();
			mirror.on(mysql).set().field(key).withValue(MYSQL_RESOURCE_BUNDLE.getObject(key));
		}
		
		return mysql;
	}
}
