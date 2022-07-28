package code.S07_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 429. N 叉树的层序遍历
 * <p>
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 * <p>
 * 示例 1：
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[[1],[3,2,4],[5,6]]
 * 示例 2：
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 * <p>
 * 提示：
 * 树的高度不会超过1000
 * 树的节点总数在 [0,10^4] 之间
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/n-ary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0429 {
    /**
     * time: O(n);      space: O(n)
     *
     * @param root N 叉树的根节点
     * @return 层序遍历
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Node> queue = new LinkedList<>();
        if (root != null) queue.offer(root);
        Node last = queue.isEmpty() ? null : queue.getLast();
        List<Integer> curLayer = new LinkedList<>();
        while (!queue.isEmpty()) {
            // 出队
            Node curNode = queue.poll();
            // 处理节点
            curLayer.add(curNode.val);
            // 加入子树
            for (Node node : curNode.children) {
                queue.offer(node);
            }
            if (curNode == last) {
                if (!queue.isEmpty()) last = queue.getLast();
                result.add(new ArrayList<>(curLayer));
                curLayer.clear();
            }
        }
        return result;
    }
}
