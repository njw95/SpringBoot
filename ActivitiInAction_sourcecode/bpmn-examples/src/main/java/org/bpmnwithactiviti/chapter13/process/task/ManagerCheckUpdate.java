package org.bpmnwithactiviti.chapter13.process.task;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.bpmnwithactiviti.chapter13.process.model.LoanApplication;

public class ManagerCheckUpdate implements JavaDelegate {

	public void execute(DelegateExecution execution) {
		LoanApplication la = (LoanApplication) execution.getVariable("loanApplication");
		if("true".equalsIgnoreCase((String) execution.getVariable("requestApproved"))) {
			la.setStatus("approved by manager");
		} else {
			la.setStatus("denied by manager");
		}
		la.setMotivation((String) execution.getVariable("motivation"));
		execution.setVariable("loanApplication", la);
	}

}
