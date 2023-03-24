package get_requests;

import base_urls.RegresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class Homework02 extends RegresBaseUrl {
    /*
        Given
          https://reqres.in/api/unknown/3
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is "application/json; charset=utf-8"
        And
            Response body should be like;(Soft Assertion)
        {
        "data": {
            "id": 3,
            "name": "true red",
            "year": 2002,
            "color": "#BF1932",
            "pantone_value": "19-1664"
        },
        "support": {
            "url": "https://reqres.in/#support-heading",
            "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
        }
}
      */


@Test
    public void homework02(){

    spec.pathParams("first","unknown","second",3);

    Response response = given().when().spec(spec).get("/{first}/{second}");
    response.prettyPrint();

    response.then().statusCode(200).contentType(ContentType.JSON);
    SoftAssert softAssert= new SoftAssert();

    JsonPath jspth = response.jsonPath();
    softAssert.assertEquals(jspth.getInt("data.id"),3);
    softAssert.assertEquals(jspth.getString("data.name"),"true red");
    softAssert.assertEquals(jspth.getInt("data.year"),2002);
    softAssert.assertEquals(jspth.getString("data.color"),"#BF1932");
    softAssert.assertEquals(jspth.getString("data.pantone_value"),"19-1664");
    softAssert.assertEquals(jspth.getString("support.url"),"https://reqres.in/#support-heading");
    softAssert.assertEquals(jspth.getString("support.text"),"To keep ReqRes free, contributions towards server costs are appreciated!");


    softAssert.assertAll();


}
}
