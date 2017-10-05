package org.camunda.bpm.Delegate;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.json.JSONObject;

public class CallOdl implements JavaDelegate{
	private static final Logger logger = Logger.getLogger(CallOdl.class.getName());
public void execute(DelegateExecution execution) throws Exception {
	
	logger.info("In CALL ODL CLASS");
	
	String deviceConfigurationJsonObject = (String) execution.getVariable("deviceConfigurationJson");
	JSONObject inputJsonObject = new JSONObject(deviceConfigurationJsonObject);
	
	String updateDeviceConfigrationURL="http://localhost:8181/restconf/config/network-topology:network-topology/topology/topology-netconf/node/router1/yang-ext:mount/router:router";
	
	String response =netClientGetUrl(updateDeviceConfigrationURL,inputJsonObject);
	
	logger.info("In RESPONSE"+response);
	
	
	
	}

static  String  netClientGetUrl(String url1, JSONObject inputJsonObject){
	// System.out.println("Inside netClientGetUrl(String url1, String parameter, String url2)");
	 
	 String response=null;
	   try {
		   
		   logger.info("Inside netClintseturl try");
		   		System.out.println("Inside netClintseturl try");
		   		String serviceresponse = null;	
			 	URL url = new URL(url1);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setDoOutput(true);
				conn.setDoInput(true);
				conn.setUseCaches(false);
				conn.setRequestMethod("PUT");
				conn.setRequestProperty("Accept", "application/json");
				conn.setRequestProperty("content-type", "application/json");
				/*conn.setRequestProperty("x-fromappid", "VID");
				conn.setRequestProperty("x-transactionid", "11112");*/
				conn.setRequestProperty("authorization ", "Basic YWRtaW46YWRtaW4=");
				
				OutputStream os = conn.getOutputStream();
				OutputStreamWriter writer = new OutputStreamWriter(os, "UTF-8");
				writer.write(inputJsonObject.toString());
		        writer.close();
				
				if (conn.getResponseCode() != 200) {
					System.out.println("Error#9");
					throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
				}
				BufferedReader br = new BufferedReader(new InputStreamReader(
						(conn.getInputStream())));
				while ((serviceresponse = br.readLine()) != null) {
					response=serviceresponse;
				}
				conn.disconnect();
			} catch (MalformedURLException e) {
				System.out.println("Error#10");
				System.out.println(e.getMessage());
			} catch (IOException e) {
				System.out.println("Error#11");
				e.printStackTrace();
				logger.info(e.getMessage());
				
			}
	 return response;
 }

}
