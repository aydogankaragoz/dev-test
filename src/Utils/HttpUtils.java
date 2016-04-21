/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goeuro.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author user
 */
public class HttpUtils {
    public static final String API_ENDPOINT = "http://api.goeuro.com/api/v2/position/suggest/en/"; 
    
    public String getApiResponse(String cityname) throws MalformedURLException, IOException{
        
        URL url = new URL(API_ENDPOINT + cityname);
        String strTemp = "";
        String apiResponse = "";
        
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        while (null != (strTemp = br.readLine())) {
            apiResponse += strTemp;
        }
        
        return apiResponse;
    } 
}

