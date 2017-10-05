package org.camunda.bpm.Delegate;
import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.json.JSONObject;

public class RetriveRestUrl implements JavaDelegate{
	private static final Logger logger = Logger.getLogger(RetriveRestUrl.class.getName());
public void execute(DelegateExecution execution) throws Exception {
	
	logger.info("In RETRIEVE REST URL CLASS");
	
	String str=(String) execution.getVariable("deviceConfigurationJson").toString();
	logger.info("String"+str);
	String replaceEquals = str.replace("=",":");
	String replaceAll = replaceEquals.replace("{","{\"");
	String finalstr = replaceAll.replace(":","\":");
	String finalstr1 = finalstr.replace(", ",", \"");
	String replace = finalstr1.replace(":", ":\"");
	String replace1 = replace.replace(",", "\",");
	String replace2 = replace1.replace("\"{", "{");
	String replace3 = replace2.replace("}\"", "}");
	String replace4 = replace3.replace("},", "\"},");
	String replace5 = replace4.replace("}},", "\"}},");
	String replace6 = replace5.replace("}\"}", "\"}}");
	String replace7 = replace6.replace("\"[", "[");
	String replace8 = replace7.replace("}]", "\"}]");
	logger.info("FINAL STRING"+replace8);
	
	
	execution.setVariable("deviceConfigurationJson", replace8);
	}

}
