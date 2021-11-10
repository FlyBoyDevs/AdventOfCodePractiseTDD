package com.flyboydevs.aoc.aoc2015;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Day3 {

    //How many houses receive at least one present
    public int countHomesVisited(String deliveryInstructions){

        Map<String, Integer> visitedHouses = new LinkedHashMap<>();
        Coordinates coordinates = new Coordinates();

        visitedHouses.put(coordinates.getKey(), 1);

        final char[] instructionsArray = deliveryInstructions.toCharArray();
        for (char c : instructionsArray) {
            determineNextVisitedHouse(coordinates, c, visitedHouses);
        }

        return visitedHouses.size();
    }

    private void determineNextVisitedHouse(Coordinates coordinates, char c, Map<String, Integer> visitedHouses) {
        switch (c){
            case '^': //North
                coordinates.moveNorth();
                break;
            case 'v': //South
                coordinates.moveSouth();
                break;
            case '>': //Eat
                coordinates.moveEast();
                break;
            case '<': //West
                coordinates.moveWest();
                break;
        }
        if (!visitedHouses.containsKey(coordinates.getKey())) {
            visitedHouses.put(coordinates.getKey(), 0);
        }
        Integer integer = visitedHouses.get(coordinates.getKey()) + 1;
        visitedHouses.put(coordinates.getKey(), integer);
    }

    public int countHomesVisitedWithRobot(String instructions) {
        Map<String, Integer> visitedHousesOutsourced = new LinkedHashMap<>();
        Coordinates coordinatesSanta = new Coordinates();
        Coordinates coordinatesRobot = new Coordinates();

        visitedHousesOutsourced.put(coordinatesSanta.getKey(), 1);
        visitedHousesOutsourced.put(coordinatesRobot.getKey(), 1);
        boolean outsourced = false;

        final char[] instructionsArray = instructions.toCharArray();
        for (char c : instructionsArray) {
            if (!outsourced) {
                determineNextVisitedHouse(coordinatesSanta, c, visitedHousesOutsourced);
            } else {
                determineNextVisitedHouse(coordinatesRobot, c, visitedHousesOutsourced);
            }
            outsourced = !outsourced;
        }

        return visitedHousesOutsourced.size();
    }


    static class Coordinates{
        int y; // North or South
        int x; // East or west

        public Coordinates(){
            this.y = 0;
            this.x = 0;
        }

       public String getKey(){
           return "y" + y + "x" + x;
       }

        public void moveNorth() {
            y++;
        }
        public void moveSouth() {
            y--;
        }
        public void moveEast() {
            x++;
        }
        public void moveWest() {
            x--;
        }
    }

}
