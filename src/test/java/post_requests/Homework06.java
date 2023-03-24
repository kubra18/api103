package post_requests;

import base_urls.RegresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Homework06 extends RegresBaseUrl {
    /*
        Given
            1) https://reqres.in/api/users
            2) {
                "name": "morpheus",
                "job": "leader"
                }
        When
            I send POST Request to the Url
        Then
            Status code is 201
            And response body should be like {
                                                "name": "morpheus",
                                                "job": "leader",
                                                "id": "393",
                                                "createdAt": "2022-10-04T15:18:56.372Z"
                                              }
     */



    @Test
    public void post06() {
        //Set the URL
        spec.pathParam("first", "users");

        //Set the expected data ==> Payload
        Map<String, String> expectedData = new HashMap<>();
        expectedData.put("name", "morpheus");
        expectedData.put("job", "Tidy leader");
        expectedData.put("id","393");

        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given().spec(spec).when().body(expectedData).post("/{first}");
        response.prettyPrint();

        //Do Assertion
        Map<String, String> actualData = response.as(HashMap.class);//De-Serialization ==> Json -> Java
        System.out.println("actualData = " + actualData);

        assertEquals(201, response.statusCode());//Status Code
        assertEquals(expectedData.get("name"), actualData.get("name"));
        assertEquals(expectedData.get("job"), actualData.get("job"));
        assertEquals(expectedData.get("id"),actualData.get("id"));

    }
}
