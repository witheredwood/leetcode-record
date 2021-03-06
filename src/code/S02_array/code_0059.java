package code.S02_array;

import java.util.Arrays;

/**
 * 59.螺旋矩阵II
 * <p>
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * <p>
 * 示例 1：
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 示例 2：
 * 输入：n = 1
 * 输出：[[1]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0059 {
  /**
   * @param n 整数
   * @return 螺旋矩阵
   */
  public int[][] generateMatrix31(int n) {
    int[][] array = new int[n][n];
    int min = 0, max = n - 1, k = 1;
    // 每次循环填空白的最外一圈
    while (min < max) {
      for (int i = min; i < max; i++) {
        array[min][i] = k++;
      }
      for (int i = min; i < max; i++) {
        array[i][max] = k++;
      }
      for (int i = max; i > min; i--) {
        array[max][i] = k++;
      }
      for (int i = max; i > min; i--) {
        array[i][min] = k++;
      }
      min++;
      max--;
    }
    if (min == max) {
      array[min][max] = k;
    }
    return array;
  }

  /**
   * @param n 整数
   * @return 螺旋矩阵
   */
  public int[][] generateMatrix(int n) {
    int[][] res = new int[n][n];
    int left = 0, right = n - 1;
    int num = 1;
    while (left <= right) {
      for (int max = left; max < right; max++) {
        res[left][max] = num++;
      }
      for (int min = left; min < right; min++) {
        res[min][right] = num++;
      }
      for (int max = right; max > left; max--) {
        res[right][max] = num++;
      }
      for (int min = right; min > left; min--) {
        res[min][left] = num++;
      }
      left++;
      right--;
    }
    if (n % 2 == 1) {
      res[n / 2][n / 2] = num;
    }
    System.out.println(Arrays.deepToString(res));
    return res;
  }
}
