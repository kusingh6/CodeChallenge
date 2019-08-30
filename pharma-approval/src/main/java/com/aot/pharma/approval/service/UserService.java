/**
 * 
 */
package com.aot.pharma.approval.service;

import com.aot.pharma.approval.domain.vo.UserVO;

/**
 * @author dheepak
 *
 */
public interface UserService {
	
	/**
	 * 
	 * @param userId
	 * @return UserVO
	 */
	UserVO getUserById(String userId);

}
