/**
 * 
 */
package com.aot.pharma.approval.application.vo;

/**
 * @author dheep
 *
 */
public class PharmaSuccessVO {
	
	private boolean status;
	
	private String message;
	
	private String referenceId;
	
	public PharmaSuccessVO() {
		
	}

	public PharmaSuccessVO(boolean status, String message, String referenceId) {
		super();
		this.status = status;
		this.message = message;
		this.referenceId = referenceId;
	}

	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the referenceId
	 */
	public String getReferenceId() {
		return referenceId;
	}

	/**
	 * @param referenceId the referenceId to set
	 */
	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

}
