package com.aot.pharma.workflow;

import java.util.HashMap;
import java.util.Map;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class processEnrollmentApplication implements JavaDelegate {

	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("processEnrollmentApplication ======================================================");
		if(execution!=null) {
			/* System.out.println(execution.getVariables()); */
			System.out.println("processEnrollmentApplication ====================================================== execution - registrationNumber "+execution.getVariable("registrationNumber"));
			System.out.println("processEnrollmentApplication ====================================================== execution - applicationId "+execution.getVariable("applicationId"));
			System.out.println("processEnrollmentApplication ====================================================== execution - applicantName "+execution.getVariable("applicantName"));
			System.out.println("processEnrollmentApplication ====================================================== execution - approval status "+execution.getVariable("status"));
		}
		Map parameters = new HashMap<>();
		parameters.put("status", execution.getVariable("status"));// put the status here once received from task.
		parameters.put("applicationId", execution.getVariable("applicationId"));
		CustomHttpClient.post(parameters);
	}

}
