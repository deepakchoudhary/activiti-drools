package org.activiti.demo.rules;

import java.io.Serializable;

public class RuleOutput implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int result;
	
	public int getResult() {
		return result;
	}
	
	public void setResult(int result) {
		this.result = result;
	}
}