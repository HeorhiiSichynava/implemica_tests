package com.implemica.work.app_2;

import com.implemica.work.app_2.City.BuildCities;
import com.implemica.work.app_2.City.City;

import java.util.HashMap;
import java.util.Map;

public class ShortWay {
    HashMap<Integer, Integer> shortWay = null;
    BuildCities buildMap;

    public ShortWay(BuildCities buildMap) {
        this.buildMap = buildMap;
        findShortWay();
    }

    //finding the shortest path
    public void findShortWay(){
        for (String str : buildMap.getSearchRequests()) {
            shortWay=new HashMap<>();
            String[] citiesAB = str.split(" ");
            City city_A = null;
            City city_B = null;
            //get cities A and B from the list according to the request
            for (City city : buildMap.getCities().values()) {
                if (city.getName().equals(citiesAB[0])) {
                    city_A = city;
                }
                if (city.getName().equals(citiesAB[1])) {
                    city_B = city;
                }
            }
            int startWeight = 0;
            shortWay.put(city_A.getID_CITY(), startWeight);

            System.out.println(findShortWay(city_A, startWeight, city_B.getID_CITY()));
        }
        return;
    }
    public int findShortWay(City city_A, int costOfPassage, int idCity_B) {
        if (city_A.getID_CITY() == idCity_B) {
            return 0;
        }
        int i = 0;
        int count = city_A.getMap().size();
        for (Map.Entry<Integer, Integer> nextCity : city_A.getMap().entrySet()) {
            if (i < count) {
                Integer idNextCity = nextCity.getKey();
                Integer costByNext = nextCity.getValue() + costOfPassage;

                if (!shortWay.containsKey(idNextCity) || shortWay.get(idNextCity) > costByNext) {
                    shortWay.put(idNextCity, costByNext);
                    findShortWay(this.buildMap.getCities().get(idNextCity), costByNext, idCity_B);
                    continue;
                } else {
                    i++;
                    continue;
                }
            }
            break;
        }
        return shortWay.get(idCity_B);
    }
}
