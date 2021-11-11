package com.flyboydevs.aoc.aoc2015;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import static com.flyboydevs.aoc.TestHelperUtils.readFileIntoList;
import static org.junit.jupiter.api.Assertions.*;

class Day3Test {

    Day3 cut;

    @BeforeEach
    void setUp() {
        cut = new Day3();
    }

    @Test
    void countHomesVisited_givenExamples_expectExampleResults() {
        assertEquals(2, cut.countHomesVisited(">"));
        assertEquals(4, cut.countHomesVisited("^>v<"));
        assertEquals(2, cut.countHomesVisited("^v^v^v^v^v"));
    }

    @Test
    void countHomesVisited_givenAOCData_expectResults() {
        final List<String> instructions = readFileIntoList( "src/test/resources/aoc2015day3");
        final int i = cut.countHomesVisited(instructions.get(0));
        System.out.println(i);
        // once answered correctly add check to avoid breaking later
        assertEquals(2565, cut.countHomesVisited(instructions.get(0)));
    }

    @Test
    void countHomesVisitedWithRobot_givenExamples_expectExampleResults() {
        assertEquals(3, cut.countHomesVisitedWithRobot("^v"));
        assertEquals(3, cut.countHomesVisitedWithRobot("^>v<"));
        assertEquals(11, cut.countHomesVisitedWithRobot("^v^v^v^v^v"));
    }
    @Test
    void countHomesVisitedWithRobot_givenAOCData_expectResults() {
        final List<String> instructions = readFileIntoList( "src/test/resources/aoc2015day3");
        final int i = cut.countHomesVisitedWithRobot(instructions.get(0));
        System.out.println(i);
        // once answered correctly add check to avoid breaking later
        assertEquals(2639, cut.countHomesVisitedWithRobot(instructions.get(0)));
    }

}
