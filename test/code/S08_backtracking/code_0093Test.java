package code.S08_backtracking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 示例 1：
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 * 输入：s = "1111"
 * 输出：["1.1.1.1"]
 * 示例 4：
 * 输入：s = "010010"
 * 输出：["0.10.0.10","0.100.1.0"]
 * 示例 5：
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 */
class code_0093Test extends code_0093 {
    String s1 = "25525511135";
    String[] expected1 = {"255.255.11.135", "255.255.111.35"};

    String s2 = "0000";
    String[] expected2 = {"0.0.0.0"};

    String s3 = "1111";
    String[] expected3 = {"1.1.1.1"};

    String s4 = "010010";
    String[] expected4 = {"0.10.0.10", "0.100.1.0"};

    String s5 = "101023";
    String[] expected5 = {"1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3"};

    @Test
    void testRestoreIpAddresses() {
        Assertions.assertArrayEquals(expected1, restoreIpAddresses(s1).toArray());
        Assertions.assertArrayEquals(expected2, restoreIpAddresses(s2).toArray());
        Assertions.assertArrayEquals(expected3, restoreIpAddresses(s3).toArray());
        Assertions.assertArrayEquals(expected4, restoreIpAddresses(s4).toArray());
        Assertions.assertArrayEquals(expected5, restoreIpAddresses(s5).toArray());
    }
}
