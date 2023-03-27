package testData;
import java.util.HashMap;
import java.util.Map;

public class ReqresTestData {

    public Map<String ,String> reqresUsersSetUp(String name, String job){
        Map<String ,String> dataMap = new HashMap<>();
        dataMap.put("name", name);
        dataMap.put("email", job);
        return dataMap;
    }

}
