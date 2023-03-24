package post_requests;

import base_urls.PetStoreBaseUrl;
import org.junit.Test;
import pojos.PetStorePojo;

public class Homework07 extends PetStoreBaseUrl {

    /*
   "https://petstore.swagger.io/" dökümanını kullanarak 'user' oluşturacak bir otomasyon testi yazınız
    Not: Test Case'i gherkin language ile yazınız.
*/


/*
 Given
            1) https://petstore.swagger.io/

            2){
  "id": 35,
  "username": "Pati Lisa",
  "firstName": "Kubra",
  "lastName": "Tanribuyurdu",
  "email": "abc@gmail.com",
  "password": "12345",
  "phone": "123454321",
  "userStatus": 0
}

 When
            I send POST Request to the Url
        Then
            Status code is 201
             And response body should be like {
                                                "id": 35,
                                                 "username": "Pati Lisa",
                                                  "firstName": "Kubra",
                                                    "lastName": "Tanribuyurdu",
                                                     "email": "abc@gmail.com",
                                                     "password": "12345",
                                                      "phone": "123454321",
                                                      "userStatus": 0
                                  }
 */
@Test
        public void test07() {

    spec.pathParam("first","user");
}



}