package org.activiti.demo.rules;

import java.io.Serializable;

public class RuleOutput implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String result;
	
	public String getResult() {
		System.out.println("Getting result from output");
		return result;
	}
	
	public void setResult(String result) {
		System.out.println("Setting result to output");
		this.result = result;
	}
	@Override
	
	public String toString() {
		return "RuleOutput [ result= " + result + "]";
	}
}