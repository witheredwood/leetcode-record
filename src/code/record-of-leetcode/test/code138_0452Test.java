package test;

import leetcode_code.code138_0452;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class code138_0452Test {
    code138_0452 one = new code138_0452();

    @Test
    void test1() {
        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
        Assertions.assertEquals(2, one.findMinArrowShots(points));
    }

    @Test
    void test2() {
        int[][] points = {{1,2},{3,4},{5,6},{7,8}};
        Assertions.assertEquals(4, one.findMinArrowShots(points));
    }

    @Test
    void test3 () {
        int[][] points = {{1,2},{2,3},{3,4},{4,5}};
        Assertions.assertEquals(2, one.findMinArrowShots(points));
    }

    @Test
    void test4 () {
        int[][] points = {{1,2}};
        Assertions.assertEquals(1, one.findMinArrowShots(points));
    }

    @Test
    void test5 () {
        int[][] points = {{2,3},{2,3}};
        Assertions.assertEquals(1, one.findMinArrowShots(points));
    }
    @Test
    void test6 () {
        int[][] points = {{-2147483646,-2147483645},{2147483646,2147483645}};
        Assertions.assertEquals(2, one.findMinArrowShots(points));
    }
}