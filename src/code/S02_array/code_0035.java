package code.S02_array;

/**
 * 35. 搜索插入位置
 * <p>
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 * 示例 1:
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * 示例2:
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * 示例 3:
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 * <p>
 * 提示:
 * 1 <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums 为无重复元素的升序排列数组
 * -10^4 <= target <= 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0035 {
  /**
   * 二分查找，[left, right)
   * 使用左开右闭的形式，跳出循环时，left=right，也表示在数组中找不到指定值。
   * 同时，从跳出循环的地方可以知道目标值的大致位置
   *
   * @param nums   数组
   * @param target 查找的目标值
   * @return 目标值在数组中的位置或者是应该插入数组的位置
   */
  public int searchInsert(int[] nums, int target) {
    int left = 0, right = nums.length;
    int mid;
    while (left < right) {
      mid = (left + right) / 2;
      if (target == nums[mid]) {
        return mid;
      } else if (target < nums[mid]) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    if (left == nums.length || target < nums[left]) {
      return left;
    }
    return left + 1;
  }
}
