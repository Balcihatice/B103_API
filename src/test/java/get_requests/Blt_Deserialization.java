package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import testData.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class Blt_Deserialization extends JsonPlaceHolderBaseUrl {
    /*
  https://jsonplaceholder.typicode.com/posts/70 post request gonderildiginde
donen rsponsun asagidaki gibi oldugunu test edin
Request body
  {
  "title": "Ahmet",
  "body": "Merhaba",
  "userId": 10,
  "id": 70
  }
Expected Data
  {
  "title": "Ahmet",
  "body": "Merhaba",
  "userId": 10,
  "id": 70
  }
oldugunu test edin

   */
    @Test
    public void test01() {
        spec.pathParams("parametre1", "posts", "parametre2", 22);

        JsonPlaceHolderTestData jsonPlaceHolderTestData = new JsonPlaceHolderTestData();
        Map<String, Object> requestBody = jsonPlaceHolderTestData.expectedDataMapOlustur();
        System.out.println(requestBody);

        //2- Expected Data
        Map<String, Object> expDataMap = jsonPlaceHolderTestData.expectedDataMapOlustur();

        //3- response kaydet

        Response response = given().
                contentType(ContentType.JSON).
                spec(spec).
                when().
                put("/{parametre1}/{parametre2}");

        response.prettyPrint();

        //4-Assertion
        assertEquals(jsonPlaceHolderTestData.basariliStatusCode,response.getStatusCode());
        // map`i json objesi ile karsilastirmak icin responsu map olarak tanimlayacak bir methda ihtiyacimiz var
       //simdiye kadar responsu json olarak kaydetmistirk,Simdi map olarak kaydedecegiz
        Map<String,Object> actualDataMap = response.as(HashMap.class);
        assertEquals(expDataMap.get("title"),actualDataMap.get("title"));
        assertEquals(expDataMap.get("body"),actualDataMap.get("body"));
        assertEquals(expDataMap.get("userId"),actualDataMap.get("userId"));
        assertEquals(expDataMap.get("id"),actualDataMap.get("id"));



    }
}
