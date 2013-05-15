package edu.thangiah.decorator;

/**
 * Intented to be an abstract class for generating html content based on entity data. Incomplete.
 * @author Kelly Smith
 *
 */
public abstract class HtmlDecorator {

	public static String generateEntityLink(String actionUrl, Long id, String value){
		return "<a href=\"" + actionUrl + "?id=" + id.toString() + "\">" + value + "</a>";
	}
}
