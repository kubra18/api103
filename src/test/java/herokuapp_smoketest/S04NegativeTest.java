package herokuapp_smoketest;


import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;


import static herokuapp_smoketest.S01_Post.bookingId;
import static io.restassured.RestAssured.given;

public class S04NegativeTest extends HerOkuAppBaseUrl {

    @Test
    public void negative() {
        spec.pathParams("first", "booking", "second", bookingId);

        Response response = given().when().spec(spec).get("/{first}/{second}");
        response.prettyPrint();

        String expected = "Not Found";

        //Do Assertion
        Assert.assertEquals(404, response.statusCode());
        Assert.assertEquals(expected, response.asString());

    }
}