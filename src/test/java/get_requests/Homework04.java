package get_requests;

import base_urls.RegresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Homework04 extends RegresBaseUrl {

    //        Given
    //            https://reqres.in/api/users/23
    //        When
    //            User send a GET Request to the url
    //        Then
    //            HTTP Status code should be 404
    //        And
    //            Status Line should be HTTP/1.1 404 Not Found
    //        And
    //            Server is "cloudflare"
    //        And
    //            Response body should be empty
    //     */
    @Test
            public void test04(){


 spec.pathParams("first","users","second",23);

    Response response = given().when().spec(spec).get("/{first}/{second}");
        response.prettyPrint();

        Assert.assertEquals(404,response.statusCode());
        Assert.assertEquals("HTTP/1.1 404 Not Found",response.statusLine());
        Assert.assertEquals("cloudflare",response.getHeader("Server"));
        Assert.assertEquals(2,response.asString().replaceAll("\\s","").length());

    }
}
