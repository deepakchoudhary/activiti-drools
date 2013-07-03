package org.activiti.demo.rules;

import java.util.Collection;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class FalseClass implements JavaDelegate {

	  @SuppressWarnings("unchecked")
	  public void execute(DelegateExecution execution) throws Exception {
		System.out.println("test output");
	    
	  
	}
}
