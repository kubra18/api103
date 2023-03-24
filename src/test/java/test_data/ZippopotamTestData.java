package test_data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZippopotamTestData {


    public List<Map<String,String>> expectedInMethod (String placeName,String longitude,String state, String stateAbbreviation,String latitude){
        Map<String,String > map = new HashMap<>();
        map.put("place name",placeName);
        map.put("longitude",longitude);
        map.put("state",state);
        map.put("state abbreviation",stateAbbreviation);
        map.put("latitude",latitude);

        List<Map<String,String>> list =new ArrayList<>();
        list.add(map);
        return list;
    }
    public Map<String ,Object> expectedDataMethod(String postCode, String country,String countryAbbrevition, List<Map<String,String>> places){
        Map<String,Object> expectedData = new HashMap<>();
        expectedData.put("post code",postCode);
        expectedData.put("country",country);
        expectedData.put("country abbreviation",countryAbbrevition);
        expectedData.put("places",places);
        return expectedData;
    }
}
