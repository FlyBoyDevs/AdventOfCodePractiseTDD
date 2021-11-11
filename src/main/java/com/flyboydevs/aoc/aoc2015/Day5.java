package com.flyboydevs.aoc.aoc2015;

import java.util.List;
import java.util.regex.Pattern;

public class Day5 {

    public long findNiceStrings(List<String> listOfStrings){

        return listOfStrings.stream()
                .filter(this::has3vowels)
                .filter(this::hasRepeatingCharacters)
                .filter(s -> !hasNaughtyCharacterSets(s))
                .count();
    }

    public long findNiceStringsPart2(List<String> listOfStrings){

        return listOfStrings.stream()
                .filter(this::hasRepeatingPairOfCharacters)
                .filter(this::has1CharacterBetweenPairs)
                .count();
    }

    boolean has3vowels(String testString){
        return Pattern.compile("[aeiou].*[aeiou].*[aeiou]")
                .matcher(testString)
                .find();
    }

    boolean hasRepeatingCharacters(String testString){
        return Pattern.compile("(\\w)\\1+")
                .matcher(testString)
                .find();
    }

    boolean hasNaughtyCharacterSets(String testString){
        return Pattern.compile("ab|cd|pq|xy")
                .matcher(testString)
                .find();
    }

    boolean hasRepeatingPairOfCharacters(String testString){
        return Pattern.compile("(..).*\\1")
                .matcher(testString)
                .find();

    }

    boolean has1CharacterBetweenPairs(String testString){
        return Pattern.compile("(.).\\1")
                .matcher(testString)
                .find();
    }

}
