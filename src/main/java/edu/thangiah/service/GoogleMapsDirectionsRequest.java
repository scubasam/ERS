package edu.thangiah.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

import edu.thangiah.entity.Location;

/**
 * Implements the Google Directions Web Service API.
 * @author Kelly Smith
 *
 */
public class GoogleMapsDirectionsRequest {
	public final static int MAX_WAYPOINTS = 8;
	public final static int MAX_URL_LENGTH = 2048;
	
	public final static String DIRECTIONS_API = "http://maps.googleapis.com/maps/api/directions/";
	
	public enum Output {json, xml};
	private Output outputMethod;
	
	// Required Parameters
	private String origin;
	private String destination;
	private boolean sensor = false;
	
	// Optional Parameters
	private String mode = "driving";
	private String[] waypoints;
	private String language = "en";
	
	public GoogleMapsDirectionsRequest(String origin, String destination) throws ServiceException{
		this(origin, destination, Output.xml);
	}
	
	public GoogleMapsDirectionsRequest(String origin, String destination, Output outputMethod) throws ServiceException{
		this(origin, destination, outputMethod, null);
	}
	
	public GoogleMapsDirectionsRequest(String origin, String destination, Output outputMethod, String[] waypoints) throws ServiceException{
		if( origin == null || origin.length() == 0 ){
			throw new ServiceException("GoogleMapsDirectionsRequest requires an origin parameter.");
		}
		
		if( destination == null || destination.length() == 0 ){
			throw new ServiceException("GoogleMapsDirectionsRequest requires an destination parameter.");
		}
		
		if(outputMethod == null)
			outputMethod = Output.xml;
		
		this.origin = origin;
		this.destination = destination;
		this.outputMethod = outputMethod;
		
		if( waypoints != null && waypoints.length > MAX_WAYPOINTS ){
			throw new ServiceException("Google Maps Web Service API does not allow for routes with more than " + (MAX_WAYPOINTS + 2) + " shipments.");
		}
		
		this.waypoints = waypoints;
	}
	
	public GoogleMapsDirectionsRequest(Location origin, Location destination, Output xml, Location[] waypoints) throws ServiceException {
		this(origin.getQualifiedName(), destination.getQualifiedName(), xml, null);
		
		String[] strWaypoints = new String[waypoints.length];
		int i = 0;
		for( Location waypoint : waypoints )
			strWaypoints[i++] = waypoint.getQualifiedName();
		
		this.waypoints = strWaypoints;
	}
	
	public static String urlEncode(String str) throws UnsupportedEncodingException{
		return URLEncoder.encode(str, "UTF-8");
	}
	
	public GoogleMapsDirectionsResponse makeRequest() throws ServiceException{
		String urlStr = buildUrl();
		if( urlStr.length() > MAX_URL_LENGTH ){
			throw new ServiceException("Google Maps Web Service API does not allow for requests longer than " + MAX_URL_LENGTH + " characters in length.");
		}
		
		BufferedReader in = null;
		try{
			URL url = new URL(urlStr);
			in = new BufferedReader(new InputStreamReader(url.openStream()));
			String inputLine, responseStr = "";
			while( (inputLine = in.readLine()) != null ){
				responseStr += inputLine;
			}
			
			return new GoogleMapsDirectionsResponse(responseStr);
		}
		catch( Exception e ){
			e.printStackTrace();
		}
		finally {
			try{
				in.close();
			}
			catch( IOException e ){
				e.printStackTrace();
			}
		}
		
		return null;
	}

	/**
	 * Builds a valid Google Maps Directions API URL based on the internal state of the current object.
	 * @return Google Maps Directions API URL
	 */
	private String buildUrl(){
		try{
			String url = DIRECTIONS_API + outputMethod.name();
			
			// required parameters
			url += "?origin=" + urlEncode(this.origin) + "&destination=" + urlEncode(this.destination) + "&sensor=" + urlEncode(new Boolean(this.sensor).toString());
			
			// optional parameters
			url += "&mode=" + urlEncode(this.mode) + "&language=" + urlEncode(this.language);
			
			if( waypoints != null && waypoints.length > 0 ){
				url += "&waypoints=";
				int count = 0;
				for( String waypoint : waypoints ){
					url += urlEncode(waypoint);
					if( count != waypoints.length-1 )
						url += "|";
					
					count++;
				}
			}
			
			return url;
		} catch(UnsupportedEncodingException e){
			return null;
		}
	}
	
}
