package APITests;

import static io.restassured.RestAssured.*;

import RequestBody.UserDefinedMethods;
import RequestBody.addAddress;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 {
	static String placeid;
//	public static void main(String[] args) {
//		testAddPlace();
//		GetPlace();
//		updatePlace() ;
//		GetPlace();
//		deletePlace();
//		//GetPlace();
//	}

    @Test(priority = 1)
    public void testAddPlace() {
        RestAssured.baseURI = "https://rahulshettyacademy.com";

        String response = given().log().all()
                .queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body(addAddress.Addplace())
                .when().post("maps/api/place/add/json")
                .then().assertThat().statusCode(200)
                .body("scope", equalTo("APP"))
                .extract().response().asString();

        JsonPath js = new JsonPath(response);
        placeid = js.get("place_id");
    }

    @Test(priority = 2)
    public void getPlace() {
        RestAssured.baseURI = "https://rahulshettyacademy.com";

        String response = given()
                .queryParam("place_id", placeid)
                .queryParam("key", "qaclick123")
                .when().post("maps/api/place/get/json")
                .then().assertThat().statusCode(200)
                .extract().response().asString();

        JsonPath jp = UserDefinedMethods.rawToJson(response);
        String address = jp.get("address");

        System.out.println(address);
    }

    @Test(priority = 3)
    public void updatePlace() {
        RestAssured.baseURI = "https://rahulshettyacademy.com";

        String response = given()
                .queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body(addAddress.updatePlace(placeid))
                .when().put("maps/api/place/update/json")
                .then().extract().response().asString();

        JsonPath jp = new JsonPath(response);
        String msg = jp.get("msg");

        Assert.assertEquals(msg, "Address successfully updated");
    }

    @Test(priority = 4)
    public void deletePlace() {
        RestAssured.baseURI = "https://rahulshettyacademy.com";

        String response = given().log().all()
                .queryParam("key", "qaclick123")
                .body(addAddress.deletePlace(placeid))
                .when().delete("maps/api/place/delete/json")
                .then().extract().asString();

        JsonPath jp = new JsonPath(response);
        String status = jp.get("status");

        System.out.println(status);
    }
    
    @Test
	public void SingleProduct() {
		Response response=given().contentType(ContentType.JSON).pathParams("id","3")
				.get("https://dummyjson.com/products/{id}");
		//response.prettyPrint();
		JsonPath js=response.jsonPath();
		Integer id=js.get("id");
		String title=js.get("title");
		String description=js.get("description");
		String category=js.get("category");
		Float price=js.get("price");
		Float discountPercentage=js.get("discountPercentage");
		Float rating=js.get("rating");

		Integer stock=js.get("stock");
		List<String> tags=js.getList("tags");
//		for(String tag:tags) {
//			System.out.println(tag);
//		}

		System.out.println(id+"\n"+title+"\n"+ description+"\n"+category+"\n"+price
				+"\n"+discountPercentage+"\n"+rating+"\n"+stock+"\n"+tags);
	}

	
}
