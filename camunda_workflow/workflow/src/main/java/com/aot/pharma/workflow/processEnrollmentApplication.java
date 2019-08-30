package com.aot.pharma.workflow;

import java.util.HashMap;
import java.util.Map;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;


public class ProcessEnrollmentApplication implements JavaDelegate {

	/**
	 * Execute will be invoked by the processs when the user clicks on the Approve/Reject buttons.
	 */
	public void execute(DelegateExecution execution) throws Exception {
		Map<String, String> parameters = new HashMap<>();
		parameters.put("status", execution.getVariable("status").toString());// put the status here once received from task.
		parameters.put("applicationId", execution.getVariable("applicationId").toString());
		PharmaHttpClient.post(parameters);
	}

}
