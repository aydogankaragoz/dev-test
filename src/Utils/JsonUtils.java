/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goeuro.Utils;

import goeuro.Models.City;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author user
 */
public class JsonUtils {
    
    public ArrayList<City> jsonStringToCityList(String strJson){
        ArrayList<City> cityList = new ArrayList<>();
        
        JSONParser parser = new JSONParser();
        Object obj = null;
        
        try {
            obj = parser.parse(strJson);
        } catch (ParseException ex) {
            Logger.getLogger(JsonUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JSONArray array;
        array = (JSONArray)obj;
        for(int i = 0 ; i < array.size(); i++){
            JSONObject objTemp = (JSONObject)array.get(i);
            
            Long id = (Long)objTemp.get("_id");
            String name = (String)objTemp.get("name");
            String type = (String)objTemp.get("type");
            JSONObject geo_position = (JSONObject)objTemp.get("geo_position");
            Double latitude = (Double)geo_position.get("latitude");
            Double longitude = (Double)geo_position.get("longitude");
            
            City tmpCity = new City(id, name, type, latitude, longitude);
            cityList.add(tmpCity);
        }
        return cityList;
    }
    
}
