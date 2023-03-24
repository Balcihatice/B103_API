package get_requests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class H03 {
/*
        Given
           https://api.covid19api.com/world/total
       When
            Kullanıcı GET Methodu ile Request Gönder
        Then
             Status Code un "200" olduğunu Assert et
        And
            Response body nin bu şekilde olduğunu doğrula
 {
    "TotalConfirmed": 674300771,
    "TotalDeaths": 6793224,
    "TotalRecovered": 0
}
 */


    @Test
    public void test01() {
        String url = "https://api.covid19api.com/world/total";

        HashMap<String, Object> expectedData = new HashMap<>();
        expectedData.put("TotalConfirmed",674300771);
        expectedData.put("TotalDeaths",6793224);
        expectedData.put("TotalRecovered",0);


        Response response = given().when().get(url);
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        response.then().statusCode(200);
        Assert.assertEquals(expectedData.get("TotalConfirmed"),jsonPath.getInt("TotalConfirmed"));
        Assert.assertEquals(expectedData.get("TotalDeaths"),jsonPath.getInt("TotalDeaths"));
        Assert.assertEquals(expectedData.get("TotalRecovered"),jsonPath.getInt("TotalRecovered"));
    }
}
