package get_requests;

import base_urls.PetStoreBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Homework08 extends PetStoreBaseUrl {
    //1) https://petstore.swagger.io/ dokumanını kullanarak statüsü "available" olan "pet" sayısını bulup 100'den
    // fazla olduğunu assert eden bir otomasyon testi yazınız.


    @Test
    public void YasinH(){
        spec.pathParams("first","pet","second","findByStatus").queryParam("status","available");

        Response response=given().when().header("Accept","application/json").spec(spec).get("/{first}/{second}");
        response.prettyPrint();


        Assert.assertTrue(response.jsonPath().getList("status").size()>100);
        System.out.println("response.jsonPath().getList(\"status\").size()>100 = " + response.jsonPath().getList("status").size());
        List<String> pet= response.jsonPath().getList("findAll{it.status=='available'}.status");
        System.out.println("pet.size() = " + pet.size());
    }}
/*
 @Test
    public void petStoreAvailablePets(){
        spec.pathParams("first","pet","second","findByStatus").
                queryParam("status","available");

        Response response=given(spec).get("{first}/{second}");
        response.prettyPrint();

        int availablePetSayisi = response.jsonPath().getList("id").size();
        assertTrue(availablePetSayisi>100);

    }
 */