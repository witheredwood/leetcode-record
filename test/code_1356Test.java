import code.S01_bit.code_1356;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class code_1356Test extends code_1356 {
    int[] arr = {0, 1, 4, 3, 6, 5, 2, 7, 8};
    int[] expected = {0, 1, 2, 4, 8, 3, 5, 6, 7};

    @Test
    void sortByBits() {
        long startTime = System.currentTimeMillis();
        Assertions.assertArrayEquals(expected, sortByBits(arr));
        long endTime = System.currentTimeMillis();
        System.out.println("执行时间：" + (endTime - startTime) + " ms");
    }
}
