package com.implemica.work.app_2.City;

import java.io.FileReader;
import java.util.*;

public class BuildCities {
    HashMap<Integer, City> cities = new HashMap<>();
    List<String> searchRequests = new ArrayList<>();

    public BuildCities(String fileName) throws Exception {

        FileReader fr = new FileReader(fileName);
        Scanner scan = new Scanner(fr);

        int i = 1;

        while (scan.hasNextLine()) {
            String str = scan.nextLine();
            switch (i) {
                case 1:
                    //the number of tests
                    int numberTest = Integer.parseInt(str);
                    break;
                case 2:
                    //the number of cities
                    int numberCities = Integer.parseInt(str);
                    for (int j = 1; j <= numberCities; j++) {
                        String nameCity = scan.nextLine();
                        int numberOfNeighboringCities = Integer.parseInt(scan.nextLine());
                        //add city
                        cities.put(j, new City(j, nameCity));
                        for (int k = 0; k < numberOfNeighboringCities; k++) {
                            String[] cityAndWeight = scan.nextLine().split(" ");
                            cities.get(j).setNeighboringCities(cityAndWeight);
                        }
                    }
                    break;
                case 3:
                    //the number of paths to find
                    int numberOfPathsToFin = Integer.parseInt(str);
                    for (int j = 0; j < numberOfPathsToFin; j++) {
                        searchRequests.add(scan.nextLine());
                    }
                    break;
            }
            i++;
        }
        fr.close();
    }

    public HashMap<Integer, City> getCities() {
        return cities;
    }

    public List<String> getSearchRequests() {
        return searchRequests;
    }
}