package org.com.data;

import org.apache.commons.lang3.RandomStringUtils;

public class Testdata {
	
	public static String getRandomName() {
		String name = RandomStringUtils.randomAlphabetic(2);
		return ("Product"+name);
	}
	
	public static String getRandomType() {
		String type = RandomStringUtils.randomAlphabetic(3);
		return ("type"+type);
	}
	
	public static int getRandomPrice() {
		String price = RandomStringUtils.randomNumeric(2);
		return (100+Integer.parseInt(price));
		
	}
	
	public static int getRandomShipping() {
		String ship = RandomStringUtils.randomNumeric(3);
		return (100+Integer.parseInt(ship));
	}
	
	public static String getRandomUPC() {
		String upc = RandomStringUtils.randomAlphabetic(3);
		return ("upc"+upc);
	}
	
	public static String getRandomDesc() {
		String desc = RandomStringUtils.randomAlphabetic(3);
		return ("desc"+desc);
	}
	
	public static String getRandomManufacturer() {
		String manufact = RandomStringUtils.randomAlphabetic(3);
		return ("manufacturer"+manufact);
	}
	
	public static String getRandomModel() {
		String model = RandomStringUtils.randomAlphabetic(3);
		return ("model"+model);
	}
	
	public static String getRandomURL() {
		String url = RandomStringUtils.randomAlphabetic(3);
		return ("https://dummyrequest.com/"+url);
	}
	
	public static String getRandomIMG() {
		String IMG = RandomStringUtils.randomAlphabetic(3);
		return ("img"+IMG);
	}
	
	
}
