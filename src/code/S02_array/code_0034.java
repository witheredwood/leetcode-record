package code.S02_array;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * <p>
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 * 你必须设计并实现时间复杂度为O(log n)的算法解决此问题。
 * <p>
 * 示例 1：
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例2：
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * <p>
 * 提示：
 * 0 <= nums.length <= 10^5
 * -10^9<= nums[i]<= 10^9
 * nums是一个非递减数组
 * -10^9<= target<= 10^9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0034 {
  /**
   * 二分查找
   * time: O(logn);     space: O(logn)
   * 递归的时间复杂度 = 递归的次数 * 每次递归中的操作次数
   *
   * @param nums   数组
   * @param target 查找的目标值
   * @return 目标值的最小下标和最大下标
   */
  public int[] searchRange(int[] nums, int target) {
    int[] result = new int[]{-1, -1};
    binary(nums, 0, nums.length, target, result);
    return result;
  }

  /**
   * 二分查找 c
   * 递归的时间复杂度 = 递归的次数 * 每次递归中的操作次数
   * time: O(logn) = O(logn) * O(1)
   * 递归空间复杂度 = 栈的大小 = 递归的深度 * 每次递归的空间复杂度
   * 栈的最大长度是递归的深度；每次递归的空间是保存局部变量，考虑参数是共享还是复制一份新的数据
   * space: O(logn) = O(logn) * O(1)
   *
   * @param nums   数组
   * @param left   数组的起始位置，包括该下标
   * @param right  数组的结束位置，不包括该下标
   * @param target 查找的目标值
   * @param result 存放目标值在数组中的开始位置和结束位置的数组
   */
  private void binary(int[] nums, int left, int right, int target, int[] result) {
    if (left == right) return;
    int mid = (left + right) / 2;
    if (target > nums[mid]) {
      binary(nums, mid + 1, right, target, result);
    } else if (target < nums[mid]) {
      binary(nums, left, mid, target, result);
    } else {
      // 更新结果 result
      if (mid > result[1]) {
        result[1] = mid;
      }
      if (result[0] == -1 || mid < result[0]) {
        result[0] = mid;
      }
      binary(nums, left, mid, target, result);
      binary(nums, mid + 1, right, target, result);
    }
  }

}
