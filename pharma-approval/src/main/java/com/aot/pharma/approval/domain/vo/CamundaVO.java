/**
 * 
 */
package com.aot.pharma.approval.domain.vo;

/**
 * @author dheep
 *
 */
public class CamundaVO {
	
	private CamundaVariableVO variables;
	
	private String businessKey;

	/**
	 * @return the variables
	 */
	public CamundaVariableVO getVariables() {
		return variables;
	}

	/**
	 * @param variables the variables to set
	 */
	public void setVariables(CamundaVariableVO variables) {
		this.variables = variables;
	}

	/**
	 * @return the businessKey
	 */
	public String getBusinessKey() {
		return businessKey;
	}

	/**
	 * @param businessKey the businessKey to set
	 */
	public void setBusinessKey(String businessKey) {
		this.businessKey = businessKey;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CamundaVO [variables=" + variables + ", businessKey=" + businessKey + "]";
	}
	
	

}
