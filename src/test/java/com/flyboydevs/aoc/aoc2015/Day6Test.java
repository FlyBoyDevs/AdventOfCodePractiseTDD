package com.flyboydevs.aoc.aoc2015;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.flyboydevs.aoc.TestHelperUtils.readFileIntoList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day6Test {

    Day6 cut;

    @BeforeEach
    void setUp() {
        cut = new Day6();
    }


    @Test
    void countLightsThatAreList_giveAOCExamples_expectAOCResults() {
        assertEquals(9, cut.countLightsThatAreLit(Collections.singletonList("turn on 0,0 through 2,2"), "1000x1000"));
        assertEquals(1000000, cut.countLightsThatAreLit(Collections.singletonList("turn on 0,0 through 999,999"), "1000x1000"));
        assertEquals(1000, cut.countLightsThatAreLit(Collections.singletonList("toggle 0,0 through 999,0"), "1000x1000"));
        assertEquals(0, cut.countLightsThatAreLit(Collections.singletonList("turn off 499,499 through 500,500"), "1000x1000"));
        assertEquals(999996, cut.countLightsThatAreLit(Arrays.asList(
                "turn on 0,0 through 999,999", "turn off 499,499 through 500,500"), "1000x1000"));
    }


    @Test
    void countLightsThatAreList_Day5Test() {
        final List<String> instructions = readFileIntoList("src/test/resources/aoc2015day6");
        assertEquals(543903, cut.countLightsThatAreLit(instructions, "1000x1000"));
    }

    @Test
    void convertConfigToMap_1000x1000_expect1millionLights() {
        final Map<String, Boolean> lights = cut.convertConfigToMap("1000x1000");
        assertEquals(1000000, lights.size());
    }

    @Test
    void testPatternMatcher() {
        final List<String> instructions = readFileIntoList("src/test/resources/aoc2015day6");
        instructions.forEach(this::patternMatcher);
    }

    void patternMatcher(String instructionLine) {
        final Pattern pattern = Pattern.compile("^(toggle|turn off|turn on) (\\d+),(\\d+) through (\\d+),(\\d+)");
        Matcher matcher = pattern.matcher(instructionLine);
        if (matcher.matches()) {
            String instruction = matcher.group(1);
            String starty = matcher.group(2);
            String startx = matcher.group(3);
            String endy = matcher.group(4);
            String endx = matcher.group(5);
            System.out.println(instruction + " y-start" + starty + " x-start" + startx + " end-y" + endy + " end-x" + endx);
        } else {
            System.out.println("no pattern matched");
        }
    }

    @Test
    void calcLightBrightness_giveAOCExamples_expectAOCResults() {
        assertEquals(1, cut.calcLightBrightness(Collections.singletonList("turn on 0,0 through 0,0"), "1000x1000"));
        assertEquals(2000000, cut.calcLightBrightness(Collections.singletonList("toggle 0,0 through 999,999"), "1000x1000"));
    }

    @Test
    void calcLightBrightness() {
        final List<String> instructions = readFileIntoList("src/test/resources/aoc2015day6");
        assertEquals(14687245, cut.calcLightBrightness(instructions,"1000x1000"));
    }
}
