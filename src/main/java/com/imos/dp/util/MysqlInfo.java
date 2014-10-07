/**
 * 
 */
package com.imos.dp.util;

import lombok.Data;

/**
 * @author Pintu
 *
 */
@Data
public class MysqlInfo {
	
	private String protocol, subprotocol, host, database, username, password, port;
	
}
