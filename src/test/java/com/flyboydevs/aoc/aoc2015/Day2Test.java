package com.flyboydevs.aoc.aoc2015;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Day2Test {

    Day2 sut;

    @BeforeEach
    void setUp() {
        sut = new Day2();
    }

    @Test()
    void howMuchWrappingPaperNeedFor_giveBadData_expectException() {
        assertThrows(InvalidParameterException.class,
                () -> sut.howMuchWrappingPaperNeedFor("2x3"),
                "Expecting 3 dimensions e.g 1x2x3"
        );
        assertThrows(InvalidParameterException.class,
                () -> sut.howMuchWrappingPaperNeedFor("2x3x3x2"),
                "Expecting 3 dimensions e.g 1x2x3"
        );
        assertThrows(InvalidParameterException.class,
                () -> sut.howMuchWrappingPaperNeedFor("2x3c3"),
                "Expecting 3 dimensions e.g 1x2x3"
        );
        assertThrows(NumberFormatException.class,
                () -> sut.howMuchWrappingPaperNeedFor("2x3xc3"),
                "Expecting 3 dimensions e.g 1x2x3"
        );
    }

    @Test
    void howMuchWrappingPaperNeedFor_give2x3x4_expect58() {
        assertEquals(58, sut.howMuchWrappingPaperNeedFor("2x3x4"));
        assertEquals(24, sut.howMuchWrappingPaperNeedFor("2x3x1"));
    }

    @Test
    void howMuchWrappingPaperNeedFor_give1x1x10_expect43() {
        assertEquals(43, sut.howMuchWrappingPaperNeedFor("1x1x10"));
    }

    @Test
    void howMuchWrappingPaperNeedFor_give1x1x2_expect7() {
        assertEquals(11, sut.howMuchWrappingPaperNeedFor("1x1x2"));
    }

    @Test
    void howMuchWrappingPaperNeedFor_giveList_expect101() {
        List<String> lines = Arrays.asList("2x3x4", "1x1x10");
        assertEquals(101, totalSquareFeetOfWrapping(lines));
    }

    @Test
    void howMuchWrappingPaperNeedFor_giveList_expect112() {
        List<String> lines = Arrays.asList("2x3x4", "1x1x10", "1x1x2");
        assertEquals(112, totalSquareFeetOfWrapping(lines));
    }

    @Test
    void howMuchWrappingPaperNeedFor_giveAOCData_expectResult() {
        String path = "src/test/resources/aoc2015day2";
        List<String> allPresents = readFileIntoList(path);
        System.out.println(totalSquareFeetOfWrapping(allPresents));
    }

    long totalSquareFeetOfWrapping(List<String> presentList) {
        return presentList.stream().mapToLong(dims -> sut.howMuchWrappingPaperNeedFor(dims)).sum();
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

    @Test
    void howMuchRibbonNeededFor() {
        assertEquals(34, sut.howMuchRibbonNeededFor("2x3x4"));
        assertEquals(34, sut.howMuchRibbonNeededFor("4x2x3"));
        assertEquals(34, sut.howMuchRibbonNeededFor("4x3x2"));
        assertEquals(14, sut.howMuchRibbonNeededFor("1x1x10"));
        assertEquals(14, sut.howMuchRibbonNeededFor("10x1x1"));
    }

    @Test
    void howMuchRibbonNeededFor_givenAOC_expectResult() {
        String path = "src/test/resources/aoc2015day2";
        List<String> allPresents = readFileIntoList(path);
        long sum = allPresents.stream().mapToLong(line -> sut.howMuchRibbonNeededFor(line)).sum();
        System.out.println(sum);
    }
}
