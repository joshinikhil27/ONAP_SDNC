package org.camunda.bpm.Delegate;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.json.JSONObject;

public class RetriveOldConfiguration implements JavaDelegate {

	private static final Logger logger = Logger.getLogger(RetriveOldConfiguration.class.getName());

	public void execute(DelegateExecution execution) throws Exception {

		String str = (String) execution.getVariable("retriveOldConfigResponse");
		String retriveOldConfigResponseObject = str.replace("}],","}]");
		
		logger.info("NIKHIL"+retriveOldConfigResponseObject);
		logger.info("EXITED RetriveOldConfiguration Method");
		
		
		if(retriveOldConfigResponseObject!=null)
		{
			execution.setVariable("retriveOldConfigResponseObject", retriveOldConfigResponseObject);
			logger.info("EXECTUTION VARIABLE SET");
		}
		
		
	}
}
