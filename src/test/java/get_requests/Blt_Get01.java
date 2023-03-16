package get_requests;


import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.json.JSONObject;

import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Blt_Get01 {
    @Test
    public void deneme() {
    /*
    https://jsonplaceholder.typicode.com/posts/44
    ststucode=2200
    contentype json
    response bodysinde bulunan userId 5,
     ve response bodysinde bulunan title in optio dolar ... oldugunu test edin
     */
        //1- Request  ve body olustur
        String url = "https://jsonplaceholder.typicode.com/posts/44";

        //2- expected datayi olustur
        JSONObject expectedBody = new JSONObject();
        expectedBody.put("userId", 5);
        expectedBody.put("title", "optio dolar molestias sit");

        //3- Response kaydet
        Response response = given().
                when().
                accept(ContentType.JSON).
                get(url);

       // response.prettyPrint();

        //4- Assertion
        response.then().//header sorgularini direk yapabiliriz
                assertThat().
                contentType(ContentType.JSON).
                statusCode(200);
         //rsponse karsilastirmaya uygun formata getirmek gerekiyor
        //jsonPath olarak kaydetmek gerekir
        JsonPath actualBody = response.jsonPath();
        Assert.assertEquals(expectedBody.get("userId"),actualBody.get("userId"));



    }
}
