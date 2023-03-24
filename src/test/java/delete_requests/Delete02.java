package delete_requests;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyRestApiDeleteBodyPojo;
import util.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Delete02 extends DummyRestApiBaseUrl {
     /*
     Given
         https://dummy.restapiexample.com/api/v1/delete/2
     When
   HTTP Request Method: DELETE Requests
    Then

             Status code is 200
             And
             "status" is "success"
            And
             "data" is "2"
            And
            "message" is "Successfully! Record has been deleted"


  */
    @Test
    public void delete02(){
        spec.pathParams("first","delete","second","2");
        DummyRestApiDeleteBodyPojo expectedData = new DummyRestApiDeleteBodyPojo("success","2","Succesfully! Record has been deleted");
        System.out.println("ExpectedData = " + expectedData);

        Response response = given(spec).delete("/{first}/{second}");
        response.prettyPrint();

        //Do assertion
        DummyRestApiDeleteBodyPojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), DummyRestApiDeleteBodyPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getStatus(), actualData.getStatus());
        assertEquals(expectedData.getData(), actualData.getData());
        assertEquals(expectedData.getMessage(), actualData.getMessage());

    }

}
