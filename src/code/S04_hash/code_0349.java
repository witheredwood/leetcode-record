package code.S04_hash;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 349. 两个数组的交集
 * <p>
 * 给定两个数组，编写一个函数来计算它们的交集。 
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * <p>
 * 说明：
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0349 {
  /**
   * time: O(n+m);    space: O(n)
   *
   * @param nums1 数组
   * @param nums2 数组
   * @return 两个数组的交集
   */
  public int[] intersection32(int[] nums1, int[] nums2) {
    // 保存nums1中的值
    // int[] 转 List ：方式一
    // Set<Integer> set1 = new HashSet<>(Arrays.stream(nums1).boxed().collect(Collectors.toList()));
    // int[] 转 List ：方式二
    Set<Integer> set1 = new HashSet<>();
    for (int i = 0; i < nums1.length; i++) {
      if (!set1.contains(nums1[i])) set1.add(nums1[i]);
    }
    // 遍历 nums2 ，求交集
    List<Integer> resultList = new ArrayList<>();
    for (int cur : nums2) {
      if (set1.contains(cur) && !resultList.contains(cur)) {
        resultList.add(cur);
      }
    }
    Integer[] result = resultList.toArray(new Integer[0]);
    return Arrays.stream(result).mapToInt(Integer::valueOf).toArray();
  }

  /**
   * time: O(n+m);    space: O(n)
   *
   * @param nums1 数组
   * @param nums2 数组
   * @return 两个数组的交集
   */
  public int[] intersection31(int[] nums1, int[] nums2) {
    // 保存nums1中的值
    Set<Integer> set1 = new HashSet<>();
    for (int i = 0; i < nums1.length; i++) {
      if (!set1.contains(nums1[i])) set1.add(nums1[i]);
    }
    // 遍历 nums2 ，求交集
    List<Integer> resultList = new ArrayList<>();
    for (int cur : nums2) {
      if (set1.contains(cur) && !resultList.contains(cur)) {
        resultList.add(cur);
      }
    }
    Integer[] result = resultList.toArray(new Integer[0]);
    return Arrays.stream(result).mapToInt(Integer::valueOf).toArray();
  }

  /**
   * @param nums1 数组
   * @param nums2 数组
   * @return 两个数组的交集
   */
  public int[] intersection(int[] nums1, int[] nums2) {
    Set<Integer> set1 = new HashSet<>(Arrays.asList(Arrays.stream(nums1).boxed().toArray(Integer[]::new)));
    Set<Integer> set2 = new HashSet<>();
    for (int val : nums2) {
      if (set1.contains(val)) {
        set2.add(val);
      }
    }
    int[] res = new int[set2.size()];
    int i = 0;
    for (int val : set2) {
      res[i++] = val;
    }
    // set 转 Integer[]，再转 int[]
//        Integer[] array = set.toArray(new Integer[0]);
//        int[] res = Arrays.stream(array).mapToInt(Integer::valueOf).toArray();
    System.out.println("res = " + Arrays.toString(res));
    return res;
  }
}
