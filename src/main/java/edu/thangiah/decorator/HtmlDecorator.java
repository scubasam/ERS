package edu.thangiah.decorator;

public abstract class HtmlDecorator {

	public static String generateEntityLink(String actionUrl, Long id, String value){
		return "<a href=\"" + actionUrl + "?id=" + id.toString() + "\">" + value + "</a>";
	}
}
