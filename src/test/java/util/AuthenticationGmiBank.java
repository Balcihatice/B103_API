package util;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class AuthenticationGmiBank {

    //once authontication nasil alinir, dokumana gidelim https://app.swaggerhub.com/apis/yasinaniltechpro/GmiBank/0.0.1#/tp-customer-resource/getTPCustomerUsingGET

    public static String generateToken(){
       Map<String, Object> postBody = new HashMap<>();
        postBody.put("password", "Batch.103");
        postBody.put("rememberMe", true);
        postBody.put("username", "batch_yuzuc");

        Response response = given().contentType(ContentType.JSON).body(postBody).post("https://gmibank.com/api/authenticate");

        return response.jsonPath().getString("id_token");
    }
}
