/**
 * 
 */
package com.aot.pharma.approval.domain.vo;

/**
 * @author dheep
 *
 */
public class CamundaPropertyVO {
	
	private String value;
	
	private String type;
	
	public CamundaPropertyVO() {
		
	}

	public CamundaPropertyVO(String value, String type) {
		super();
		this.value = value;
		this.type = type;
	}



	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CamundaPropertyVO [value=" + value + ", type=" + type + "]";
	}
	
	

}
