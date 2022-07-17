package code.S02_array;

/**
 * 941. 有效的山脉数组
 * 给定一个整数数组 arr，如果它是有效的山脉数组就返回 true，否则返回 false。
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 * arr.length >= 3
 * 在 0 < i < arr.length - 1 条件下，存在 i 使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * <p>
 * 示例 1：
 * 输入：arr = [2,1]
 * 输出：false
 * 示例 2：
 * 输入：arr = [3,5,5]
 * 输出：false
 * 示例 3：
 * 输入：arr = [0,3,2,1]
 * 输出：true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-mountain-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0941 {
  /**
   * 山脉数组，只有1个单调递增子数组和1个单调递减子数组
   * time: O(n);    space: O(1)
   *
   * @param arr 给定的整数数组
   * @return true-该数组是先增后减数组；false-该数组不是先增后减数组
   */
  public boolean validMountainArray31(int[] arr) {
    if (arr.length < 3) return false;
    int index = 1;
    // 找到上升子数组的右端点
    while (index < arr.length && arr[index] > arr[index - 1]) index++;
    if (index == 1 || index == arr.length) return false;  // 没有上升子数组或者只有上升子数组，均返回错误
    // 找到下降子数组的右端点
    while (index < arr.length && arr[index] < arr[index - 1]) index++;
    return index == arr.length;
  }

  /**
   * @param arr 给定的整数数组
   * @return true-该数组是先增后减数组；false-该数组不是先增后减数组
   */
  public boolean validMountainArray(int[] arr) {
    int len = arr.length;
    if (len < 3) return false;
    int index = 1;
    while (index < len && arr[index] > arr[index - 1]) {
      index++;
    }
    // 单调递增或单调递减数组都不是山脉
    if (index == 1 || index >= len) return false;
    while (index < len && arr[index] < arr[index - 1]) {
      index++;
    }
    return index >= len;
  }
}
