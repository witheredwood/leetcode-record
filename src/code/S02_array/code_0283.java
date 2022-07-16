package code.S02_array;

/**
 * 283. 移动零
 * <p>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * <p>
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0283 {
  /**
   * 给定的数组包含正数和负数
   *
   * @param nums 给定的数组
   */
  public void moveZeroes31(int[] nums) {
    int index = 0;
    for (int oldPoint = 0; oldPoint < nums.length; oldPoint++) {
      if (nums[oldPoint] != 0) {  // 非0则复制
        nums[index++] = nums[oldPoint];
      }
    }
    while (index < nums.length) nums[index++] = 0;
  }

  /**
   * @param nums 给定的数组
   */
  public void moveZeroes(int[] nums) {
    int left = 0;
    for (int right = 0; right < nums.length; right++) {
      if (nums[right] != 0) {
        nums[left++] = nums[right];
      }
    }
    while (left < nums.length) nums[left++] = 0;
  }
}
