/**
 * 
 */
package com.aot.pharma.approval.domain.vo;

/**
 * @author dheep
 *
 */
public class CamundaVariableVO {
	
	private CamundaPropertyVO applicationId;
	
	private CamundaPropertyVO registrationNumber;
	
	private CamundaPropertyVO applicantName;

	/**
	 * @return the applicationId
	 */
	public CamundaPropertyVO getApplicationId() {
		return applicationId;
	}

	/**
	 * @param applicationId the applicationId to set
	 */
	public void setApplicationId(CamundaPropertyVO applicationId) {
		this.applicationId = applicationId;
	}

	/**
	 * @return the registrationNumber
	 */
	public CamundaPropertyVO getRegistrationNumber() {
		return registrationNumber;
	}

	/**
	 * @param registrationNumber the registrationNumber to set
	 */
	public void setRegistrationNumber(CamundaPropertyVO registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	/**
	 * @return the applicantName
	 */
	public CamundaPropertyVO getApplicantName() {
		return applicantName;
	}

	/**
	 * @param applicantName the applicantName to set
	 */
	public void setApplicantName(CamundaPropertyVO applicantName) {
		this.applicantName = applicantName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CamundaVariableVO [applicationId=" + applicationId + ", registrationNumber=" + registrationNumber
				+ ", applicantName=" + applicantName + "]";
	}
	
	

}
