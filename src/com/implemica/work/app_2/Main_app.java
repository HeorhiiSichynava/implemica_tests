package com.implemica.work.app_2;

import com.implemica.work.app_2.City.BuildCities;

public class Main_app {
    //the app calculates the lowest fare from city A to city B
    public static void main(String[] args) throws Exception {
        //specify the path to the input data and build cities
        BuildCities readMap = new BuildCities("/home/heorhii/IdeaProjects/implemica_tests/src/com/implemica/work/app_2/map.txt");
        //calculate the minimum fare according to the cities built
        ShortWay shortWay = new ShortWay(readMap);
    }
}
