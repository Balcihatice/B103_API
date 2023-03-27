package homework;

import base_urls.PetstoreBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.path.json.JsonPath.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class H_23_03 extends PetstoreBaseUrl {

//1) https://petstore.swagger.io/ dokumanını kullanarak statüsü "available" olan "pet" sayısını bulup 100'den fazla olduğunu assert eden bir otomasyon testi yazınız.

    /*
       Given
           https://petstore.swagger.io/v2/pet/findByStatus?status=available
       When
           User sens Get request
       Then
           Assert that number of pets whose status is "available" is more than 100
        */
  //  @Test
//    public void petStoreAvailablePets(){
//        spec.pathParams("first","pet","second","findByStatus").
//                queryParam("status","available");
//
//        Response response=given(spec).get("{first}/{second}");
//        response.prettyPrint();
//
//        int availablePetSayisi = response.jsonPath().getList("id").size();
//        assertTrue(availablePetSayisi>100);
//
//    }


/*2)
	Given
		https://automationexercise.com/api/productsList
	When
		User sends Get request
	Then
		Assert that number of "Women" usertype is 12
		(Kadın usertype sayısının 12 olduğunu doğrulayın)

*/

//    @Test
//    public void automationExerciseTest(){
//        spec.pathParam("first","productsList");
//        Response response = given(spec).get("{first}");
//        response.jsonPath().prettyPrint();
//        JsonPath jsonPath = response.jsonPath();
//        //Assert that number of "Women" usertype is 12 -->Kadın usertype sayısının 12 olduğunu doğrulayın
//        int kadinUserTypeSayisi = jsonPath.getList("products.findAll{it.category.usertype.usertype=='Women'}").size();
//        assertEquals(12,kadinUserTypeSayisi);
//    }

}

