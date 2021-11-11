package com.flyboydevs.aoc.aoc2015;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.flyboydevs.aoc.TestHelperUtils.readFileIntoList;
import static org.junit.jupiter.api.Assertions.*;

class Day5Test {

    Day5 cut;

    @BeforeEach
    void setUp() {
        cut = new Day5();
    }

    @Test
    void findNiceStrings_giveAOCExamples_expectAOCResults() {
        assertTrue(cut.has3vowels("aei"));
        assertTrue(cut.has3vowels("xazegov"));
        assertTrue(cut.has3vowels("aeiouaeiouaeiou"));

        assertTrue(cut.hasRepeatingCharacters("xx"));
        assertTrue(cut.hasRepeatingCharacters("abcdde"));
        assertTrue(cut.hasRepeatingCharacters("aabbccdd"));

        assertTrue(cut.hasNaughtyCharacterSets("ab"));
        assertTrue(cut.hasNaughtyCharacterSets("cd"));
        assertTrue(cut.hasNaughtyCharacterSets("pq"));
        assertTrue(cut.hasNaughtyCharacterSets("xy"));

        assertFalse(cut.hasRepeatingCharacters("jchzalrnumimnmhp"));
        assertTrue(cut.hasNaughtyCharacterSets("haegwjzuvuyypxyu"));
        assertFalse(cut.has3vowels("dvszwmarrgswjxmb"));

        cut.findNiceStrings(Collections.singletonList("abcccdefe"));

        assertEquals(1, cut.findNiceStrings(Collections.singletonList("ugknbfddgicrmopn")));
        assertEquals(1, cut.findNiceStrings(Collections.singletonList("aaa")));
        assertEquals(0, cut.findNiceStrings(Collections.singletonList("jchzalrnumimnmhp")));
        assertEquals(0, cut.findNiceStrings(Collections.singletonList("haegwjzuvuyypxyu")));
        assertEquals(0, cut.findNiceStrings(Collections.singletonList("dvszwmarrgswjxmb")));

        assertEquals(0, cut.findNiceStrings(
                Arrays.asList("dvszwmarrgswjxmb",
                        "zgsnvdmlfuplrubt",
                        "vlhagaovgqjmgvwq",
                        "ffumlmqwfcsyqpss",
                        "zztdcqzqddaazdjp",
                        "eavfzjajkjesnlsb"
                )));
    }

    @Test
    void findNiceStrings_givenAOCData_expectResults() {
        final List<String> naughtyNiceList = readFileIntoList( "src/test/resources/aoc2015day5");
        long i = cut.findNiceStrings(naughtyNiceList);
        System.out.println(i);
        // once answered correctly add check to avoid breaking later
        assertEquals(238, cut.findNiceStrings(naughtyNiceList));
    }


    @Test
    void findNiceStringsPrt2_giveAOCExamples_expectAOCResults() {
        assertTrue(cut.hasRepeatingPairOfCharacters("xyxy"));
        assertTrue(cut.hasRepeatingPairOfCharacters("aabcdefgaa"));
        assertFalse(cut.hasRepeatingPairOfCharacters("aaa"));

        assertTrue(cut.has1CharacterBetweenPairs("xyx"));
        assertTrue(cut.has1CharacterBetweenPairs("abcdefeghi"));
        assertTrue(cut.has1CharacterBetweenPairs("aaa"));

        assertTrue(cut.hasRepeatingPairOfCharacters("qjhvhtzxzqqjkmpb") && cut.has1CharacterBetweenPairs("qjhvhtzxzqqjkmpb"));
        assertTrue(cut.hasRepeatingPairOfCharacters("xxyxx") && cut.has1CharacterBetweenPairs("xxyxx"));
        assertFalse(cut.hasRepeatingPairOfCharacters("uurcxstgmygtbstg") && cut.has1CharacterBetweenPairs("uurcxstgmygtbstg"));
        assertFalse(cut.hasRepeatingPairOfCharacters("ieodomkazucvgmuy") && cut.has1CharacterBetweenPairs("ieodomkazucvgmuy"));

        assertEquals(1, cut.findNiceStringsPart2(Arrays.asList("qjhvhtzxzqqjkmpb")));
        assertEquals(1, cut.findNiceStringsPart2(Arrays.asList("xxyxx")));
        assertEquals(0, cut.findNiceStringsPart2(Arrays.asList("uurcxstgmygtbstg")));
        assertEquals(0, cut.findNiceStringsPart2(Arrays.asList("ieodomkazucvgmuy")));
    }

    @Test
    void findNiceStringsPrt2_givenAOCData_expectResults() {
        String path = "src/test/resources/aoc2015day5";
        final List<String> naughtyNiceList = readFileIntoList(path);
        long i = cut.findNiceStringsPart2(naughtyNiceList);
        System.out.println(i);
        // once answered correctly add check to avoid breaking later
        assertEquals(69, cut.findNiceStringsPart2(naughtyNiceList));
    }
}
