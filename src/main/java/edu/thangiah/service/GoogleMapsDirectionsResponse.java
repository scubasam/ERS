package edu.thangiah.service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.xpath.*;

import org.w3c.dom.*;
import org.xml.sax.InputSource;

public class GoogleMapsDirectionsResponse {
	private String responseStr;
	private boolean errors = false;
	private ArrayList<String> errorMessages = new ArrayList<String>();
	
	public GoogleMapsDirectionsResponse(String response){
		responseStr = response;
		
		parseResponse();
	}
	
	private void parseResponse(){
		
		XPathFactory factory = XPathFactory.newInstance();

	    XPath xpath = factory.newXPath();
		
		InputStream is = new ByteArrayInputStream(responseStr.getBytes());
		InputSource inputXml = new InputSource(is);
		
		try {
			Node node = (Node) xpath.evaluate("/DirectionsResponse/status", inputXml, XPathConstants.NODE);
			String status = node.getTextContent();
			if( !status.equals("OK") ){
				addError("Maps Service was not able to generate a directions list.");
				return;
			}
			
			/*NodeList durations = (NodeList) xpath.evaluate("/DirectionsResponse/route/leg/duration/value", inputXml, XPathConstants.NODESET);
			for( int i=0; i < durations.getLength(); i++ ){
				Node duration = durations.item(i);
				String value = duration.getTextContent();
			}*/
			
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			addError("Invalid XML Response.");
			e.printStackTrace();
			return;
		}
	}
	
	public boolean hasErrors(){
		return errors;
	}
	
	public void addError(String error){
		errors = true;
		errorMessages.add(error);
	}
	
	public String[] getErrorMessages(){
		return (String[]) errorMessages.toArray();
	}
}
