package code.S02_array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class code_0941Test extends code_0941 {
    int[] arr1 = {2,1};
    boolean expected1 = false;

    int[] arr2 = {3,5, 5};
    boolean expected2 = false;

    int[] arr3 = { 0, 3, 2, 1};
    boolean expected3 = true;

    @Test
    void testValidMountainArray() {
        System.out.println("arr1 = " + Arrays.toString(arr1));
        Assertions.assertEquals(expected1, validMountainArray(arr1));
    }

    @Test
    void testValidMountainArray2() {
        System.out.println("arr = " + Arrays.toString(arr2));
        Assertions.assertEquals(expected2, validMountainArray(arr2));
    }

    @Test
    void testValidMountainArray3() {
        System.out.println("arr = " + Arrays.toString(arr3));
        Assertions.assertEquals(expected3, validMountainArray(arr3));
    }
}
