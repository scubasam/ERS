package edu.thangiah.service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.xpath.*;

import org.w3c.dom.*;
import org.xml.sax.InputSource;

/**
 * Implements the Google Directions Web Service API for making requests.  Implements functionality for parsing specific information used
 * in route calculations.
 * @author Kelly Smith
 *
 */
public class GoogleMapsDirectionsResponse {
	public static final int FEET_PER_MILE = 5280;
	public static final int SECONDS_PER_DAY = 86400;
	
	private String responseStr;
	private boolean errors = false;
	private ArrayList<String> errorMessages = new ArrayList<String>();
	
	private Integer duration;
	private Integer distance;
	
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
			Node primaryNode = (Node) xpath.evaluate("/DirectionsResponse", inputXml, XPathConstants.NODE);
			
			Node node = (Node) xpath.evaluate("status", primaryNode, XPathConstants.NODE);
			String status = node.getTextContent();
			if( !status.equals("OK") ){
				addError("Maps Service was not able to generate a directions list.");
				return;
			}
			
			int totalDuration = 0;
			NodeList durations = (NodeList) xpath.evaluate("route/leg/duration/value", primaryNode, XPathConstants.NODESET);
			if( durations != null ){
				for( int i=0; i < durations.getLength(); i++ ){
					Node duration = durations.item(i);
					String value = duration.getTextContent();
					totalDuration += Integer.parseInt(value);
					System.out.println("testing");
				}
			}
			this.setDuration(new Integer(totalDuration));
			
			int totalDistance = 0;
			NodeList distances = (NodeList) xpath.evaluate("route/leg/distance/value", primaryNode, XPathConstants.NODESET);
			if( distances != null ){
				for( int i=0; i < distances.getLength(); i++ ){
					Node distance = distances.item(i);
					String value = distance.getTextContent();
					totalDistance += Integer.parseInt(value);
					System.out.println("testing");
				}
			}
			this.setDistance(new Integer(totalDistance));
			
		} catch (XPathExpressionException e) {
			addError("Invalid XML Response.");
			e.printStackTrace();
			return;
		}
		catch (NumberFormatException e){
			addError("Invalid Duration Response.  Could not parse an integer.");
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

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}
}
