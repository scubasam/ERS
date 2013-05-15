package edu.thangiah.service;

/**
 * Intended to be used as a generic exception for all services that get implemented.  Currently only the GoogleMaps services use it.
 * @author Kelly Smith
 *
 */
public class ServiceException extends Exception{
	private static final long serialVersionUID = -6573868123081570438L;

	public ServiceException(String message){
		super(message);
	}
}
