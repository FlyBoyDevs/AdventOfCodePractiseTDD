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

        cut.findNiceStrings(Arrays.asList("abcccdefe"));

        assertEquals(1, cut.findNiceStrings(Arrays.asList("ugknbfddgicrmopn")));
        assertEquals(1, cut.findNiceStrings(Arrays.asList("aaa")));
        assertEquals(0, cut.findNiceStrings(Arrays.asList("jchzalrnumimnmhp")));
        assertEquals(0, cut.findNiceStrings(Arrays.asList("haegwjzuvuyypxyu")));
        assertEquals(0, cut.findNiceStrings(Arrays.asList("dvszwmarrgswjxmb")));



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
        String path = "src/test/resources/aoc2015day3";
        final List<String> naughtyNiceList = readFileIntoList(path);
        long i = cut.findNiceStrings(naughtyNiceList);
        System.out.println(i);
        // once answered correctly add check to avoid breaking later
        assertEquals(2639, cut.findNiceStrings(naughtyNiceList));
    }

    public static List<String> readFileIntoList(String file) {
        List<String> lines = Collections.emptyList();
        try {
            lines = Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
