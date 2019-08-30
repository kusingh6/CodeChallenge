/**
 * 
 */
package com.aot.pharma.approval.domain.vo;

/**
 * View Object for user
 * @author Dheepak Ramanathan
 *
 */
public class ApplicationVO {
	
	private String applicationId;
	
	private String applicationStatus;
	
	private String applicantName;
	
	private Long pharmacistRegNo;
	


	/**
	 * @return the applicationId
	 */
	public String getApplicationId() {
		return applicationId;
	}

	/**
	 * @param applicationId the applicationId to set
	 */
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	/**
	 * @return the applicationStatus
	 */
	public String getApplicationStatus() {
		return applicationStatus;
	}

	/**
	 * @param applicationStatus the applicationStatus to set
	 */
	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	/**
	 * @return the applicantName
	 */
	public String getApplicantName() {
		return applicantName;
	}

	/**
	 * @param applicantName the applicantName to set
	 */
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	/**
	 * @return the pharmacistRegNo
	 */
	public Long getPharmacistRegNo() {
		return pharmacistRegNo;
	}

	/**
	 * @param pharmacistRegNo the pharmacistRegNo to set
	 */
	public void setPharmacistRegNo(Long pharmacistRegNo) {
		this.pharmacistRegNo = pharmacistRegNo;
	}

}
