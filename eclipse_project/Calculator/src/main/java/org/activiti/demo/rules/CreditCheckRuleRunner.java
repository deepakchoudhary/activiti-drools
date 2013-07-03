package org.activiti.demo.rules;

//import java.io.File;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.activiti.demo.rules.RuleInput;
import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderConfiguration;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.compiler.PackageBuilder;
import org.drools.compiler.PackageBuilderConfiguration;
import org.drools.event.DebugAgendaEventListener;
import org.drools.event.DebugWorkingMemoryEventListener;
import org.drools.event.rule.AgendaEventListener;
import org.drools.event.rule.WorkingMemoryEventListener;
import org.drools.io.ResourceFactory;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.rule.builder.dialect.java.JavaDialectConfiguration;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.StatelessKnowledgeSession;

public class CreditCheckRuleRunner {

	public static String runRules(RuleInput ruleInput) throws Exception {
		System.out.println("Kick it" + ruleInput.getOper());
		KnowledgeBase kbase = readKnowledgeBase();
		
		System.out.println("debugging class CheckCreditRules");
		StatelessKnowledgeSession ksession = kbase.newStatelessKnowledgeSession();
		System.out.println("Fire the rules!");
		ksession.execute(ruleInput);
		return ruleInput.getOper();
	}

	private static KnowledgeBase readKnowledgeBase() throws Exception {
		
		String filename = "/home/deepak/Documents/eclipse_project/Calculator/rules.drl";
		File rulefile = new File(filename);
		System.out.println(rulefile.canRead());
		System.out.println("debugging class CheckCreditRule1");
		Properties properties = new Properties();
	       properties.setProperty( "drools.dialect.java.compiler","JANINO" );
	       PackageBuilderConfiguration cfg = new PackageBuilderConfiguration( properties );
	       JavaDialectConfiguration javaConf = (JavaDialectConfiguration) cfg.getDialectConfiguration( "java" );

	       PackageBuilder builder = new PackageBuilder(cfg);
		
	       System.out.println("debugging class CheckCreditRule2");
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder(cfg);
		System.out.println("debugging class CheckCreditRule3");
		kbuilder.add(
				ResourceFactory.newFileResource( rulefile ),
                ResourceType.DRL);
		System.out.println("debugging class part1");
		KnowledgeBuilderErrors errors = kbuilder.getErrors();
		System.out.println("debugging class part2");
		if (errors.size() > 0) {
			for (KnowledgeBuilderError error : errors) {
				System.err.println(error);
			}
			throw new IllegalArgumentException("Could not parse knowledge.");
		}
		KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
		kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
		/*
		final StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
		
		DebugAgendaEventListener listener1 = new DebugAgendaEventListener();
		
		        

		// setup the audit logging

		KnowledgeRuntimeLogger logger =

		  KnowledgeRuntimeLoggerFactory.newFileLogger(ksession, "log/helloworld");
		*/
		return kbase;
	}

}
