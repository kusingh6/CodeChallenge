/**
 * 
 */
package com.aot.pharma.approval;

import java.util.UUID;

/**
 * @author dheep
 *
 */
public class TestClass {
	
	public static void main(String arga[]) {
		UUID uuid = UUID.randomUUID();
		String id = uuid.toString().substring(0, 8);
		System.out.println(id);
	}

}
