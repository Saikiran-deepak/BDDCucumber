package RequestBody;

public class addAddress {

	public static String Addplace() {
		return "{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Frontline house2\",\r\n"
				+ "  \"phone_number\": \" 111 222 3333\",\r\n"
				+ "  \"address\": \"29, Kiran side layout, cohen 09\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"ENG-IN\"\r\n"
				+ "}";
	}
	
	public static String updatePlace(String placeid) {
		return "{\r\n"
				+ "    \"place_id\": \""+placeid+"\",\r\n"
				+ "    \"address\": \"70 Deepak winter walk, USA\",\r\n"
				+ "    \"key\": \"qaclick123\"\r\n"
				+ "}";
	}
	
	public static String deletePlace(String placeid) {
		
		return "{\r\n"
				+ "\r\n"
				+ "    \"place_id\":\""+placeid+"\"\r\n"
				+ "}\r\n"
				+ "";
	}
}
