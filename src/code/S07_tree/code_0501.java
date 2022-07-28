package code.S07_tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 501. 二叉搜索树中的众数
 * <p>
 * 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
 * 如果树中有不止一个众数，可以按 任意顺序 返回。
 * <p>
 * 假定 BST 满足如下定义：
 * 结点左子树中所含节点的值 小于等于 当前节点的值
 * 结点右子树中所含节点的值 大于等于 当前节点的值
 * 左子树和右子树都是二叉搜索树
 * <p>
 * 示例 1：
 * 输入：root = [1,null,2,2]
 * 输出：[2]
 * 示例 2：
 * 输入：root = [0]
 * 输出：[0]
 * <p>
 * 提示：
 * 树中节点的数目在范围 [1, 10^4] 内
 * -10^5 <= Node.val <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-mode-in-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0501 {
    /**
     * 中序遍历+计数+排序
     * time: (nlogn);       space: O(n)
     *
     * @param root 二叉搜索树（BST）的根节点
     * @return BST 中的所有 众数
     */
    public int[] findMode32(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        inorder(root, map);
        // 排序
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        Collections.sort(entryList, (a, b) -> {
            if (a.getValue() != b.getValue()) return b.getValue() - a.getValue();
            return a.getKey() - b.getKey();
        });
        // 找出众数
        List<Integer> resultList = new LinkedList<>();
        for (int index = 0; index < entryList.size() && entryList.get(index).getValue() == entryList.get(0).getValue(); index++) {
            resultList.add(entryList.get(index).getKey());
        }
        return Arrays.stream(resultList.toArray(new Integer[0])).mapToInt(Integer::valueOf).toArray();
    }

    private void inorder(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return;
        inorder(root.left, map);
        if (!map.containsKey(root.val)) {
            map.put(root.val, 1);
        } else {
            map.replace(root.val, map.get(root.val) + 1);
        }
        inorder(root.right, map);
    }
}
