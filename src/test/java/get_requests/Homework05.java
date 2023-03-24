package get_requests;

import base_urls.RegresBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

public class Homework05 extends RegresBaseUrl {
    /*
       Given
              https://reqres.in/api/unknown/
       When
            I send GET Request to the URL
       Then

            1)Status code is 200
            2)Print all pantone_values
              (Tüm pantone_value değerlerini yazdırınız)
            3)Print all ids greater than 3 on the console
              (3'ten büyük id'leri yazdırınız)
              Assert that there are 3 ids greater than 3
              (3'ten büyük 3 adet id olduğunu doğrulayınız)
            4)Print all names whose ids are less than 3 on the console
              (id'si 3'ten küçük isimleri yazdırınız)
              Assert that the number of names whose ids are less than 3 is 2
              (id'si 3'ten küçük 2 isim olduğunu doğrulayınız)
    */
    @Test
    public void get05() {
        
        
        //        i)   Set the URL
        spec.pathParam("first", "unknown");
        //        ii)  Set the expected data

//        iii) Send the request and get the response
        Response response = given().spec(spec).get("{first}");
        response.prettyPrint();

//        iv)  Do assertion
        response.
                then().
                statusCode(200);
        JsonPath jsonPath = response.jsonPath();
        List<String> pantone_value = jsonPath.getList("data.pantone_value");
        System.out.println("pantone_value = " + pantone_value);


                List<Integer> list = jsonPath.getList("data.findAll{it.id>3}.id");
                System.out.println("list = " + list);
                assertEquals(3, list.size());
        
        List<String> isimlist = jsonPath.getList("data.findAll{it.id<3}.name");
        System.out.println("isimlist = " + isimlist);
        assertEquals(2, isimlist.size());

        
    }

}


