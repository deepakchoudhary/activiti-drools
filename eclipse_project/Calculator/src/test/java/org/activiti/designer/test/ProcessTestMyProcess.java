package org.activiti.designer.test;

//import static org.junit.Assert.*;

//import java.util.HashMap;
//import java.util.Map;
//import java.io.FileInputStream;

import org.activiti.demo.rules.CreditCheckRuleRunner;
import org.activiti.demo.rules.RuleInput;
//import org.activiti.engine.RepositoryService;
//import org.activiti.engine.RuntimeService;
//import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.test.ActivitiRule;
import org.junit.Rule;
import org.junit.Test;

//import org.activiti.demo.rules.RuleInput;
public class ProcessTestMyProcess {

	//private String filename = "/home/deepak/Documents/eclipse_project/Calculator/MyProcess.bpmn";

	@Rule
	public ActivitiRule activitiRule = new ActivitiRule();

	
	
	@Test
	public void testCreditCheckFailed(){
		RuleInput ruleInput = new RuleInput();
		ruleInput.setOper("fozzie");
		System.out.println(ruleInput.getOper());
		
		String result;
		System.out.println("yo after string");
		try {
			 result = CreditCheckRuleRunner.runRules(ruleInput);
		} catch (Exception e) {
			e.printStackTrace();
			result="yo";
		}	
		System.out.println(result);
	}
	
/*	@Test
	public void testCreditCheckPassed(){

		kermit.setName("Kermit");
		kermit.setIncome(1000);
		kermit.setLoanAmount(10);
		
		boolean result = false;
		
		try {
			 result = CreditCheckRuleRunner.runRules(kermit);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	@Test
	public void startProcess() throws Exception {
		RepositoryService repositoryService = activitiRule.getRepositoryService();
		repositoryService.createDeployment().addInputStream("myProcess.bpmn20.xml",
				new FileInputStream(filename)).deploy();
		RuntimeService runtimeService = activitiRule.getRuntimeService();
		Map<String, Object> variableMap = new HashMap<String, Object>();
		variableMap.put("fuck", "fozzie");
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess", variableMap);
		assertNotNull(processInstance.getId());
		System.out.println("id " + processInstance.getId() + " "
				+ processInstance.getProcessDefinitionId());
	
	}
*/
}