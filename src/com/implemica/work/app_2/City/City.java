package com.implemica.work.app_2.City;

import java.util.Arrays;
import java.util.HashMap;

public class City {
    private Integer ID_CITY;
    private String name;
    private HashMap<Integer, Integer> map;

    public City(Integer ID_CITY, String name) {
        this.ID_CITY = ID_CITY;
        this.name = name;
        this.map = new HashMap();
    }

    //establish communication with cities and indicate the cost
    public void setNeighboringCities(String[] citiesAndWeights) {
        map.put(Integer.parseInt(citiesAndWeights[0]), Integer.parseInt(citiesAndWeights[1]));
    }

    public int getID_CITY() {
        return ID_CITY;
    }

    public String getName() {
        return name;
    }

    public HashMap<Integer, Integer> getMap() {
        return map;
    }

    @Override
    public String toString() {
        return "City{" +
                "ID_CITY=" + ID_CITY +
                ", name='" + name + '\'' +
                ", map=" + map +
                '}';
    }
}
