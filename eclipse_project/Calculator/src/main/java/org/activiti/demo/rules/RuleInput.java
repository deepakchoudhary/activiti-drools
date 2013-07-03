package org.activiti.demo.rules;

import java.io.Serializable;

public class RuleInput implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String oper;
	
	public String getOper() {
		System.out.println("getting operator");
		return oper;
	}
	
	public void setOper(String oper) {
		System.out.println("Setting operator");
		this.oper = oper;
	}
	
	

	@Override
	public String toString() {
		return "RuleInput [oper=" + oper + "]";
	}
}
