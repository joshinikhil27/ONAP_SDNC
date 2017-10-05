package org.camunda.bpm.Delegate;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.json.JSONObject;

public class EvaluatePreTest implements JavaDelegate {

	private static final Logger logger = Logger.getLogger(EvaluatePreTest.class.getName());

	public void execute(DelegateExecution execution) throws Exception {

		logger.info("In Execute Method");
		String preTestResponse = (String) execution.getVariable("preTestResponseJSON");
		preTestResponse = preTestResponse.replaceAll("\n", "\\n");
		logger.info("PRE TEST JSON"+preTestResponse);
		JSONObject preTestResponseOject = new JSONObject(preTestResponse);
		String status = preTestResponseOject.getString("response_body");
		logger.info("PRE TEST Status" + status);
		execution.setVariable("preTestStatus", status);
		if (status.equals("Success")) {
			logger.info("INSIDE ADD ROUTER" + status);
			execution.setVariable("saveDeviceConfigurationURL", "http://localhost:8282/addRouterConfigDetails");
		} else if (!status.equals("Success")) {
			logger.info("INSIDE RETRIVE LATEST INFO" + status);
			execution.setVariable("retriveOldDeviceConfigurationURL", "http://localhost:8282/getLatestConfigDetails/router");
			logger.info("retrive method called" );
			
		}

	}
}
