package code_1356;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class code_1356Test extends code_1356 {
    int[] arr = {0, 1, 4, 3, 6, 5, 2, 7, 8};
    int[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8};

    @Test
    void sortByBits() {
        Assertions.assertArrayEquals(expected, sortByBits(arr));
    }
}
