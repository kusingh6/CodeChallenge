/**
 * 
 */
package com.aot.pharma.approval.domain.vo;

/**
 * @author dheep
 *
 */
public class BearerTokenVO {
	
	private String sub;
	
	private String name;
	
	private String email;

	/**
	 * @return the sub
	 */
	public String getSub() {
		return sub;
	}

	/**
	 * @param sub the sub to set
	 */
	public void setSub(String sub) {
		this.sub = sub;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BearerTokenVO [sub=" + sub + ", name=" + name + ", email=" + email + "]";
	}
	
	

}
