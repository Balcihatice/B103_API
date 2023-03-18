package testData;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {

    public int basariliStatusCode = 200;

    public JSONObject expectedDataOlustur() {
        JSONObject body = new JSONObject();
        body.put("userId", 3);
        body.put("id", 22);
        body.put("title", "dolor sint quo a velit explicabo quia nam");
        body.put("body", "eos qui et ipsum ipsam suscipit aut\n" +
                "sed omnis non odio\n" +
                "expedita earum mollitia molestiae aut atque rem suscipit\n" +
                "nam impedit esse");
        return body;
    }


    public Map expectedDataMapOlustur() {
        Map<String, Object> requestBodyMap = new HashMap<>();
        requestBodyMap.put("title", "Ahmet");
        requestBodyMap.put("body", "Merhaba");
        requestBodyMap.put("userId", 10);
        requestBodyMap.put("id", 70);
        return requestBodyMap;
    }

    /*
    Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("userId", 21);
        expectedData.put("title", "Wash the dishes");
        expectedData.put("completed", false);
     */
    public Map<String, Object> expectedDataMethod(Integer userId, String title, Boolean completed) {

        Map<String, Object> expectedData = new HashMap<>();
        if (userId != null) {
            expectedData.put("userId", userId);
        }
        if (title != null) {
            expectedData.put("title", title);
        }
        if (completed != null) {
            expectedData.put("completed", completed);
        }
        return expectedData;
    }
}