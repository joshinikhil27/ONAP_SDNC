package org.camunda.bpm.Delegate;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.model.bpmn.BpmnModelInstance;
import org.json.JSONObject;




public class ProcessDeviceConfiguration  implements JavaDelegate  {


	    private String status;
	private static final Logger logger = Logger.getLogger(ProcessDeviceConfiguration.class.getName());
	
	public void execute(DelegateExecution execution) throws Exception {
		try
		{
		logger.info("In PROCESS DEVICE CLASS");
		
		// Process Response.

logger.info("DCR"+execution.getVariable("deviceConfigurationResponse"));

		
		execution.setVariable("deviceConfigurationStatus", "SUCCESS");
		

			JSONObject devicePreTestRequestObject = new JSONObject();
			devicePreTestRequestObject.put("IP", "127.0.0.1");
			execution.setVariable("performPreTestJSON", devicePreTestRequestObject.toString());
			logger.info("IN PRETEST");
			execution.setVariable("devicePreTestURL", "http://localhost:8282/runPreTest");
			logger.info("AFTER PRETEST"+execution);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
