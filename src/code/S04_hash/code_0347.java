package code.S04_hash;

import java.util.*;

/**
 * 347. 前 K 个高频元素
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * <p>
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0347 {
	/**
	 * 优先级队列
	 *
	 * @param nums 给定的正整数数组
	 * @param k    给定的返回前几个高频数
	 * @return 前 k 个高频数的数组
	 */
	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		// 计数
		for (int val : nums) {
			if (map.containsKey(val)) map.replace(val, map.get(val) + 1);
			else map.put(val, 1);
		}
		// 使用优先级队列排序
		PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
			return map.get(a) - map.get(b);
		});
		for (int key : map.keySet()) {
			queue.offer(key);
			if (queue.size() > k) queue.poll();
		}
		int[] res = new int[k];
		int i = 0;
		while (!queue.isEmpty()) {
			res[i++] = queue.poll();
		}
		return res;
	}

	/**
	 * 计数+排序+哈希
	 *
	 * @param nums 给定的正整数数组
	 * @param k    给定的返回前几个高频数
	 * @return 前 k 个高频数的数组
	 */
	public int[] topKFrequent1(int[] nums, int k) {
		Map<Integer, Integer> map = new TreeMap<>();
		// 计数
		for (int val : nums) {
			if (map.containsKey(val))
				map.replace(val, map.get(val) + 1);
			else
				map.put(val, 1);
		}
		List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			@Override
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return o2.getValue() - o1.getValue(); // 降序
			}
		});
		// 返回结果
		int[] res = new int[k];
		for (int i = 0; i < k; i++) {
			res[i] = list.get(i).getKey();
		}
		System.out.println("res = " + Arrays.toString(res));
		return res;
	}
}
