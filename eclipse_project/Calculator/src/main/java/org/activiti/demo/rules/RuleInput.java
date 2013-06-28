package org.activiti.demo.rules;

import java.io.Serializable;

public class RuleInput implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String myresult;
	private String oper;
	
	public String getMyresult() {
		return myresult;
	}
	
	public void setMyresult(String myresult) {
		this.myresult = myresult;
	}
	
	public String getOper() {
		return oper;
	}
	
	public void setOper(String oper) {
		this.oper = oper;
	}
	
	

	@Override
	public String toString() {
		return "RuleInput [oper=" + oper + ", myresult="
				+ myresult + "]";
	}
}
