package com.flyboydevs.aoc.aoc2015;

public class Day1 {

    public int whatFloorIsSantaOn(String instructions) {
        int count = 0;
        char[] instructionsArray = instructions.toCharArray();
        for (char c : instructionsArray) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
            }
        }
        return count;
    }

    public int whenDidSantaFirstArriveOnFloorX(String instructions, int floor){
        for (int i = 1; i <= instructions.length(); i++) {
            if (whatFloorIsSantaOn(instructions.substring(0, i)) == floor) return i;
        }
        return 0;
    }

}
