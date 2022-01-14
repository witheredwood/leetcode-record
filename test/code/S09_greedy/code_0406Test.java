package code.S09_greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

/**
 * 示例 1：
 * 输入：people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}}
 * 输出：{{5,0},{7,0},{5,2},{6,1},{4,4},{7,1}}
 * 解释：
 * 编号为 0 的人身高为 5 ，没有身高更高或者相同的人排在他前面。
 * 编号为 1 的人身高为 7 ，没有身高更高或者相同的人排在他前面。
 * 编号为 2 的人身高为 5 ，有 2 个身高更高或者相同的人排在他前面，即编号为 0 和 1 的人。
 * 编号为 3 的人身高为 6 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
 * 编号为 4 的人身高为 4 ，有 4 个身高更高或者相同的人排在他前面，即编号为 0、1、2、3 的人。
 * 编号为 5 的人身高为 7 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
 * 因此 {{5,0},{7,0},{5,2},{6,1},{4,4},{7,1}} 是重新构造后的队列。
 * 示例 2：
 * 输入：people = {{6,0},{5,0},{4,0},{3,2},{2,2},{1,4}}
 * 输出：{{4,0},{5,0},{2,2},{3,2},{1,4},{6,0}}
 */
class code_0406Test extends code_0406 {
    int[][] people1 = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
    int[][] expected1 = {{5, 0}, {7, 0}, {5, 2}, {6, 1}, {4, 4}, {7, 1}};

    int[][] people2 = {{6, 0}, {5, 0}, {4, 0}, {3, 2}, {2, 2}, {1, 4}};
    int[][] expected2 = {{4, 0}, {5, 0}, {2, 2}, {3, 2}, {1, 4}, {6, 0}};

    @Test
    void testReconstructQueue() {
        System.out.println("people = " + Arrays.deepToString(people1));
        Assertions.assertArrayEquals(expected1, reconstructQueue(people1));
        System.out.println("-----------------------");
        Assertions.assertArrayEquals(expected2, reconstructQueue(people2));
    }
}
