package ru.levelup.pavel_kustov.qa.homework1.task4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *  Class show answer on 1st home work
 *  tasks 4:
 *  test Rtriangle
 *
 * @version 1.0
 * @author  Kustov Pavel
 */

public class Main {

    public static void main(String[] args) {
        startApp();
    }

    public static void startApp()
    {
        RightTriangle triangle = RtriangleProvider.getRtriangle();
        if ( testRTriangle(triangle) > 0 ) {
            System.out.println("Error in the triangle");
            return;
        }

    }

    /**
     * Checking that the triangle is rectangular
     * @param rtriangle
     * @return 0 - if true
     */
    public static int testRTriangle(Rtriangle rtriangle)
    {
        List <Double> sides = new ArrayList();
        sides.add(getLength(rtriangle.getApexX1(), rtriangle.getApexX2(),
                                    rtriangle.getApexY1(), rtriangle.getApexY2()));
        sides.add(getLength(rtriangle.getApexX2(), rtriangle.getApexX3(),
                                    rtriangle.getApexY2(), rtriangle.getApexY3()));
        sides.add(getLength(rtriangle.getApexX3(), rtriangle.getApexX1(),
                                    rtriangle.getApexY3(), rtriangle.getApexY1()));

        Collections.sort(sides);

        //Checking the absence of a null side
        assert(sides.get(0) > 0);
        if (sides.get(0) == 0)
            return 1;

        double angle1 = Math.toDegrees(Math.asin(sides.get(0) / sides.get(2)));
        double angle2 = Math.toDegrees(Math.asin(sides.get(1) / sides.get(2)));

        //Checking sum of two angles
        assert((angle1 + angle2) == 90);
        if ((angle1 + angle2) != 90)
            return 2;

        return 0;
    }

    /**
     * Calculate length of the side
     * @return length
     */
    private static double getLength(int x1, int x2, int y1, int y2)
    {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }


}
