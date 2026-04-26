package APITests;

import static io.restassured.RestAssured.given;

import java.io.File;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class SendingJsonFromExternalFile {
public static void main(String[] args) {
	Response response=given().contentType(ContentType.JSON).body(new File("C:\\Users\\kiran\\eclipse-workspace\\Rest_Assurd\\TestData\\customer.json"))			
							.post("https://rahulshettyacademy.com/maps/api/place/add/json?key=qaclick123");
	response.prettyPrint();
}
}
