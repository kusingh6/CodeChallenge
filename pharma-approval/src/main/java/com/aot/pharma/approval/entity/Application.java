/**
 * 
 */
package com.aot.pharma.approval.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Dheepak Ramanathan
 *
 */
@Entity
@Table(name="application")
public class Application {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="application_id")
	private Long id;
	
	@Column(name = "external_id")
	private String applicationId;
	
	@Column(name = "applicant_name")
	private String applicantName;
	
	@Column(name = "pharmacist_reg_no")
	private Long pharmacistRegNo;
	
	@Column(name = "user_id")
	private String userId;
	
	@Column(name = "created_on")
	private Date createdOn;
	
	@Column(name = "applicant_status")
	private String applicationStatus;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

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

	/**
	 * @return the createdOn
	 */
	public Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @return the applicationStatus
	 */
	public String getApplicationStatus() {
		return (applicationStatus==null) ? "IN PROGRESS" : applicationStatus ;
	}

	/**
	 * @param applicationStatus the applicationStatus to set
	 */
	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}
}
