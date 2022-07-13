package code.S02_array;

/**
 * 31. 下一个排列
 * <p>
 * 整数数组的一个 排列 就是将其所有成员以序列或线性顺序排列。
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，
 * 那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列
 * （即，其元素按升序排列）。
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 * 必须 原地 修改，只允许使用额外常数空间。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 * 示例 3：
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 * <p>
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0031 {
  /**
   * 以数组 [7, 10,9,5,4] 和 [4,3,2,1]为例，说明解题的过程。（index 均是下标，为了描述简介，下面均以该下标上的值代替）
   * [7, 10,9,5,4] 的过程
   * 1. 找到 maxIndex 10
   * 2. 对调 [10,9,5,4]，得到数组 [7,4,5,9,10]
   * 3. 找到 minIndex 9
   * 4. 交换 7 和 9，得到数组 [9,4,5,7,10]
   * <p>
   * [4,3,2,1]的过程
   * 1. 找到 maxIndex 0
   * 2. 对调 [4,3,2,1]，得到数组 [1,2,3,4]
   * 3. 结束
   */

  /**
   * time: O(n);    space: O(1)
   *
   * @param nums 数组
   */
  public void nextPermutation(int[] nums) {
    // 从后向前找，找到第一个反序的数
    int maxLenIndex = nums.length - 1;
    while (maxLenIndex > 0 && nums[maxLenIndex] <= nums[maxLenIndex - 1]) maxLenIndex--;
    // 前后对换
    for (int i = maxLenIndex, j = nums.length - 1; i < j; i++, j--) {
      int tmp = nums[i];
      nums[i] = nums[j];
      nums[j] = tmp;
    }
    if (maxLenIndex == 0) return;
    int swapIndex = maxLenIndex - 1;
    // 找到大于 swapIndex 的值的数中的最小值
    int minIndex = maxLenIndex;
    while (minIndex < nums.length && nums[minIndex] <= nums[swapIndex]) minIndex++;
    int tmp = nums[swapIndex];
    nums[swapIndex] = nums[minIndex];
    nums[minIndex] = tmp;
  }
}
