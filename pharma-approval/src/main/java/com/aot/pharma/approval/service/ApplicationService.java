/**
 * 
 */
package com.aot.pharma.approval.service;

import java.util.List;

import com.aot.pharma.approval.application.vo.PharmaSuccessVO;
import com.aot.pharma.approval.domain.vo.ApplicationVO;
import com.aot.pharma.approval.domain.vo.BearerTokenVO;

/**
 * @author Dheepak Ramanathan
 *
 */
public interface ApplicationService {
	
	/**
	 * Get all applications
	 * @return List<ApplicationVO>
	 */
	List<ApplicationVO> getAllApplications(String userId);
	
	/**
	 * Get all applications based on status
	 * @param applicationStatus
	 * @return List<ApplicationVO>
	 */
	List<ApplicationVO> getApplicationByStatus(String applicationStatus);
	
	/**
	 * 
	 * @param applicationId
	 * @return ApplicationVO
	 */
	ApplicationVO getApplicationById(String applicationId);
	
	/**
	 * 
	 * @param application
	 * @return PharmaSuccessVO
	 */
	PharmaSuccessVO createApplication(ApplicationVO application,BearerTokenVO userToken);
	
	/**
	 * 
	 * @param application
	 * @return PharmaSuccessVO
	 */
	PharmaSuccessVO updateApplication(String applicationId,String applicationStatus);
	
	/**
	 * 
	 * @param applicationId
	 * @return
	 */
	List<ApplicationVO> getApplicationByUserId(String userId);
}
