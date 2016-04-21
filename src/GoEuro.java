/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goeuro;
import goeuro.Models.City;
import goeuro.Utils.HttpUtils;
import goeuro.Utils.JsonUtils;
import goeuro.Utils.CSVUtils;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author user
 */
public class GoEuro {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        if (args.length != 1) {
            System.out.println("Usage: java -jar GoEuroTest.jar \"CITY_NAME\"");
            return;
        }
        String city = args[0];
        HttpUtils httpUtils = new HttpUtils();
        JsonUtils jsonUtils = new JsonUtils();
        CSVUtils csvUtils = new CSVUtils();
        
        String apiResponse = httpUtils.getApiResponse(city);
        
        ArrayList<City> cityList = jsonUtils.jsonStringToCityList(apiResponse);

        String fileName = csvUtils.cityListToCSV(city, cityList);
        
        System.out.println(fileName + " created.");
    }

}
