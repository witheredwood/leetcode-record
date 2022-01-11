package code.S05_string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 示例 1：
 * 输入：s = ['h','e','l','l','o']
 * 输出：['o','l','l','e','h']
 * 示例 2：
 * 输入：s = ['H','a','n','n','a','h']
 * 输出：['h','a','n','n','a','H']
 */
class code_0344Test extends code_0344 {
    char[] s1 = {'h','e','l','l','o'}, expected1 = {'o','l','l','e','h'};
    char[] s2 = {'H','a','n','n','a','h'}, expected2 = {'h','a','n','n','a','H'};
    @Test
    void testReverseString() {
        System.out.println("s1 = " + Arrays.toString(s1));
        reverseString(s1);
        System.out.println("s1 = " + Arrays.toString(s1));
        System.out.println("-----------------------");
        System.out.println("s2 = " + Arrays.toString(s1));
        reverseString(s2);
        System.out.println("s2 = " + Arrays.toString(s2));
    }
}
