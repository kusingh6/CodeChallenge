/**
 * 
 */
package com.aot.pharma.approval.domain.vo;

/**
 * View object for User
 * @author Dheepak Ramanathan
 *
 */
public class UserVO {
	
	private String userId;
	
	private String userName;

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
