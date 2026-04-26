package RequestBody;

import io.restassured.path.json.JsonPath;

public class UserDefinedMethods {

	public static JsonPath rawToJson(String response) {
		JsonPath jp=new JsonPath(response);	
		return jp;
	}
}
