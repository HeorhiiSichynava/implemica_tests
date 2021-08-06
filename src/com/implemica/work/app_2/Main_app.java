package com.implemica.work.app_2;

import com.implemica.work.app_2.City.BuildCities;

import java.nio.file.FileSystems;
import java.nio.file.Path;

public class Main_app {
    //the app calculates the lowest fare from city A to city B
    public static void main(String[] args) throws Exception {
        //specify the path to the input data and build cities
        Path path = FileSystems.getDefault().getPath("src/com/implemica/work/app_2", "map.txt");
        BuildCities readMap = new BuildCities(path.toString());
        //calculate the minimum fare according to the cities built
        ShortWay shortWay = new ShortWay(readMap);
    }
}
