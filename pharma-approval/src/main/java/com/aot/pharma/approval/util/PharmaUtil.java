/**
 * 
 */
package com.aot.pharma.approval.util;

import java.util.UUID;

/**
 * @author dheep
 *
 */
public class PharmaUtil {
	
	public static String generateExternalId() {
		UUID uuid = UUID.randomUUID();
		String externalId = uuid.toString().substring(0, 8);
		return externalId;
	}

}
