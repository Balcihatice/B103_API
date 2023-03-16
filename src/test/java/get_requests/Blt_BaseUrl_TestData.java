package get_requests;

import base_urls.JsonplaceholderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import testData.JsonPlaceHolderTestData;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Blt_BaseUrl_TestData extends JsonplaceholderBaseUrl {

    /*
    {{JsonPlaceHolderBaseUrl}}/22 adresine gidip
    statuscode 200
    respocse bodynin
    {
    "userId": 3,
    "id": 22,
    "title": "dolor sint quo a velit explicabo quia nam",
    "body": "eos qui et ipsum ipsam suscipit aut
sed omnis non odio
expedita earum mollitia molestiae aut atque rem suscipit
nam impedit esse"
}
oldugunu test edin
//Bu bizim expecteddatamiz
     */

    @Test
    public void test01() {
        spec.pathParams("parametre1", "posts", "parametre2", 22);


        //expectedata olustur

        JsonPlaceHolderTestData jsonPlaceHolder = new JsonPlaceHolderTestData();
        JSONObject expectedData = jsonPlaceHolder.expectedDataOlustur();


        //response kaydet
        Response response = given().
                spec(spec).
                when().
                get("/{parametre1}/{parametre2}");

        response.prettyPrint();

        //Assertion
        JsonPath jsonPath = response.jsonPath();
        assertEquals(jsonPlaceHolder.basariliStatusCode, response.statusCode());
        assertEquals(expectedData.getInt("userId"), jsonPath.getInt("userId"));
        assertEquals(expectedData.getInt("id"), jsonPath.getInt("id"));
        assertEquals(expectedData.getString("title"), jsonPath.getString("title"));
        assertEquals(expectedData.getString("body"), jsonPath.getString("body"));

    }
}

