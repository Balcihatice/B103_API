package get_requests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Blt_Post01 {
    /*
    https://jsonplaceholder.typicode.com/posts post request gonderildiginde
    {
    "title": "API",
    "body": "API ogrenmek guzel",
    "userId": 112
    }
    donen response un status code 200

    ve contenttypein application/json
    ve response bodysinin id haric
    {
    "title": "API",
    "body": "API ogrenmek guzel",
    "userId": 112,
    "id": 101
}
oldugunu test edin

     */
    @Test
    public void post01() {

        String url = "https://jsonplaceholder.typicode.com/posts";

        //gonderecegimiz body
        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "API");
        requestBody.put("body", "Api ogrenmek guzeldir");
        requestBody.put("userId", 10);

        //expected Data olustur
        JSONObject expectedBody = new JSONObject();
        expectedBody.put("title", "API");
        expectedBody.put("body", "Api ogrenmek guzeldir");
        expectedBody.put("userId", 10);

        //Response kaydet
        Response response = given().
                contentType(ContentType.JSON).
                when().
                body(requestBody.toString()).
                post(url);
        JsonPath actualBody = response.jsonPath();

        //Assertion
        response.then().
                assertThat().
                contentType(ContentType.JSON).
                statusCode(201);


        Assert.assertEquals(expectedBody.get("title"), actualBody.get("title"));
        Assert.assertEquals(expectedBody.get("userId"), actualBody.get("userId"));
        Assert.assertEquals(expectedBody.get("body"), actualBody.get("body"));

    }
}