package herokuapp_smoketest;


import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static herokuapp_smoketest.S01_Post.bookingId;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static util.AuthenticationHerOkuApp.generateToken;

    public class S03_Delete extends HerOkuAppBaseUrl {
        /*
        Given
            https://restful-booker.herokuapp.com/booking/429
        When
            Send delete request
        Then
            Status code should be 201
        And
            Body should be "Created"
         */
        @Test
        public void delete() {


            spec.pathParams("first","booking","second",bookingId);

            String expectedData = "Created";

            Response response =
                    given()
                            .spec(spec)
                            //bu kismi spec'e ekledik .header("Cookie","token="+generateToken())
                            .when()
                            .delete("/{first}/{second}");
            response.prettyPrint();

            Assert.assertEquals(201,response.statusCode());

            Assert.assertEquals(expectedData,response.asString());

        }}


