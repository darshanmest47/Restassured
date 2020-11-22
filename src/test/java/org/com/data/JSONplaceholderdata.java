package org.com.data;

import org.apache.commons.lang3.RandomStringUtils;

public class JSONplaceholderdata {
	
	
	public static int getRandomUserId() {
		
		String randomUserid = RandomStringUtils.randomNumeric(4);
		return(Integer.parseInt(randomUserid));
	}
	
	public static int getRandomId() {
		String randomId = RandomStringUtils.randomNumeric(3);
		return(Integer.parseInt(randomId));
	}
	
	public static String getRandomTitle() {
		String randomtitle = RandomStringUtils.randomNumeric(4);
		return("mr"+randomtitle);
		
	}
	
	public static String getRandomBody() {
		String body = RandomStringUtils.randomAlphabetic(3);
		return("agent number "+body);
	}
	
	public static int getRandomIDNumber() {
		String randomId = RandomStringUtils.randomNumeric(1);
		return(Integer.parseInt(randomId));
	}
	
	public static int getRandomSingleid() {
		String randomId = RandomStringUtils.randomNumeric(1);
		return(Integer.parseInt(randomId));
	}
	

}
