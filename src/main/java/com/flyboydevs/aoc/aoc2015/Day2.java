package com.flyboydevs.aoc.aoc2015;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Day2 {

    public long howMuchWrappingPaperNeedFor(String dimensions) {
        Present present = new Present(dimensions);
        //smallest area of box
        return present.totalSquareFeet;
    }

    public long howMuchRibbonNeededFor(String dimensions) {
        Present present = new Present(dimensions);
        //smallest area of box
        return present.totalRibbon;
    }

    static class Present {
        int length;
        int width;
        int height;
        int slack;
        int totalSquareFeet;
        int totalRibbon;

        public Present(String dimensions) {
            final String[] dimensionsArray = dimensions.split("x");
            if (dimensionsArray.length != 3)
                throw new InvalidParameterException("Expecting 3 dimensions e.g 1x2x3");
            this.length = Integer.parseInt(dimensionsArray[0]);
            this.width = Integer.parseInt(dimensionsArray[1]);
            this.height = Integer.parseInt(dimensionsArray[2]);
            List<Integer> sides = Arrays.asList(length * width, width * height, height * length);
            this.slack = Collections.min(sides);
            int surfaceArea = 2 * length * width + 2 * width * height + 2 * height * length;
            totalSquareFeet = surfaceArea+ slack;

            //shortest distance around its sides
            int shortestDistance =
                    Collections.min(Arrays.asList(2 * length + 2 * width, 2 * width + 2 * height, 2 * height + 2 * length));
            //the bow
            int theBlow = length * width * height;
            totalRibbon = shortestDistance + theBlow;
        }
    }

}
