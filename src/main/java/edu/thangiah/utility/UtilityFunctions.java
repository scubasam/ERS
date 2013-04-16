package edu.thangiah.utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilityFunctions {
	
	private static final String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	//http://regexlib.com/DisplayPatterns.aspx?categoryId=7
	private static final String PHONE_PATTERN = 
			"^[\\(]{0,1}([0-9]){3}[\\)]{0,1}[ ]?([^0-1]){1}([0-9]){2}[ ]?[-]?[ ]?([0-9])"
			+ "{4}[ ]*((x){0,1}([0-9]){1,5}){0,1}$";
	
	// http://www.sha1-online.com/sha1-java/
	public static String sha1(String input){
		MessageDigest mDigest;
		try {
			mDigest = MessageDigest.getInstance("SHA1");
			byte[] result = mDigest.digest(input.getBytes());
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < result.length; i++) {
	            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
	        }
	         
	        return sb.toString();
	    }
	    catch(NoSuchAlgorithmException e) {
	        e.printStackTrace();
	    }
		return null;
    }
	
	//http://www.mkyong.com/regular-expressions/how-to-validate-email-address-with-regular-expression/
	public static boolean validateEmail(final String email){
		if( email != null ){
			Pattern pattern = Pattern.compile(EMAIL_PATTERN);
			Matcher matcher = pattern.matcher(email);
			return matcher.matches();
		}
		return false;
	}
	
	
	public static boolean validatePhone(final String phone){
		/*if( phone != null ){
			Pattern pattern = Pattern.compile(PHONE_PATTERN);
			Matcher matcher = pattern.matcher(phone);
			return matcher.matches();
		}
		return false;*/
		String parsedPhone = phone.replace("(", "");
		parsedPhone = parsedPhone.replace(")", "");
		parsedPhone = parsedPhone.replace("-", "");
		parsedPhone = parsedPhone.replace(" ", "");
		
		if( parsedPhone.length() < 10 || parsedPhone.length() > 11 ){
			return false;
		}
		
		return true;
	}
	
	
}
