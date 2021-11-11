package com.flyboydevs.aoc.aoc2015;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day6 {

    public long countLightsThatAreLit(List<String> santaInstructions, String lightArrayConfig) {
        final Map<String, Boolean> lightsMap = convertConfigToMap(lightArrayConfig);

        santaInstructions.forEach(s -> setupLights(lightsMap, s));

        return lightsMap.values().stream()
                .filter(lightValue -> lightValue.equals(true))
                .count();
    }

    public long calcLightBrightness(List<String> santaInstructions, String lightArrayConfig) {
        final Map<String, Integer> lightsMap = convertConfigToMapPrt2(lightArrayConfig);

        santaInstructions.forEach(instructionLine -> {
            int starty;
            int startx;
            int endy;
            int endx;
            String instruction;

            final Pattern pattern = Pattern.compile("^(toggle|turn off|turn on) (\\d+),(\\d+) through (\\d+),(\\d+)");
            Matcher matcher = pattern.matcher(instructionLine);
            if (matcher.matches()) {
                instruction = matcher.group(1);
                starty = Integer.parseInt(matcher.group(2));
                startx = Integer.parseInt(matcher.group(3));
                endy = Integer.parseInt(matcher.group(4));
                endx = Integer.parseInt(matcher.group(5));
            } else {
                throw new RuntimeException("Instruction not supported:" + instructionLine);
            }

            for (int i = starty; i <= endy; i++) {
                for (int j = startx; j <= endx; j++) {
                    setThisLightPrt2(lightsMap, i, j, instruction);
                }
            }
        });

        return lightsMap.values().stream()
                .mapToLong(value -> value)
                .sum();
    }

    private void setupLights(Map<String, Boolean> lightsMap, String instructionLine) {
        int starty;
        int startx;
        int endy;
        int endx;
        String instruction;

        final Pattern pattern = Pattern.compile("^(toggle|turn off|turn on) (\\d+),(\\d+) through (\\d+),(\\d+)");
        Matcher matcher = pattern.matcher(instructionLine);
        if (matcher.matches()) {
            instruction = matcher.group(1);
            starty = Integer.parseInt(matcher.group(2));
            startx = Integer.parseInt(matcher.group(3));
            endy = Integer.parseInt(matcher.group(4));
            endx = Integer.parseInt(matcher.group(5));
        } else {
            throw new RuntimeException("Instruction not supported:" + instructionLine);
        }

        for (int i = starty; i <= endy; i++) {
            for (int j = startx; j <= endx; j++) {
                setThisLight(lightsMap, i, j, instruction);
            }
        }

    }

    private void setThisLight(Map<String, Boolean> lightsMap, int i, int j, String instruction) {
        switch (instruction) {
            case "toggle":
                lightsMap.put(getKey(i, j), !lightsMap.get(getKey(i, j)));
                break;
            case "turn off":
                lightsMap.put(getKey(i, j), false);
                break;
            case "turn on":
                lightsMap.put(getKey(i, j), true);
                break;
            default:
                throw new RuntimeException("Instruction not supported:" + instruction);
        }

    }

    private void setThisLightPrt2(Map<String, Integer> lightsMap, int i, int j, String instruction) {
        Integer currentValue = lightsMap.get(getKey(i, j));
        switch (instruction) {
            case "toggle":
                currentValue = currentValue + 2;
                break;
            case "turn off":
                currentValue = currentValue - 1;
                currentValue = currentValue > 0 ? currentValue : 0;
                break;
            case "turn on":
                currentValue = currentValue + 1;
                break;
            default:
                throw new RuntimeException("Instruction not supported:" + instruction);
        }
        lightsMap.put(getKey(i, j), currentValue);

    }

    Map<String, Boolean> convertConfigToMap(String lightArrayConfig) {
        Map<String, Boolean> lights = new LinkedHashMap<>();
        String[] dimensionsArray = lightArrayConfig.split("x");
        final int y = Integer.parseInt(dimensionsArray[0]);
        final int x = Integer.parseInt(dimensionsArray[1]);

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                lights.put(getKey(i, j), false);
            }
        }
        return lights;
    }

    Map<String, Integer> convertConfigToMapPrt2(String lightArrayConfig) {
        Map<String, Integer> lights = new LinkedHashMap<>();
        String[] dimensionsArray = lightArrayConfig.split("x");
        final int y = Integer.parseInt(dimensionsArray[0]);
        final int x = Integer.parseInt(dimensionsArray[1]);

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                lights.put(getKey(i, j), 0);
            }
        }
        return lights;
    }

    private String getKey(int y, int x) {
        return "Y:" + y + "X:" + x;
    }

}
