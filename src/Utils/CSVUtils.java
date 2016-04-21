/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goeuro.Utils;

import goeuro.Models.City;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class CSVUtils {

    public String cityListToCSV(String city, ArrayList<City> cityList) {
        String fileName = city + ".csv";
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName);
            for (int i = 0; i < cityList.size(); i++) {
                writer.append(cityList.get(i).toCsv());
                writer.append("\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(CSVUtils.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(CSVUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return fileName;
    }
}
