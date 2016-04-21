/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goeuro.Models;

/**
 *
 * @author user
 */
public class City {

    Long id;
    String name;
    String type;
    Double latitude;
    Double longitude;

    public City(Long id, String name, String type,
            Double latitude, Double longitude) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String toCsv() {
        return id + ", " + name + ", " + type + ", " + latitude + ", " + longitude;
    }

}
