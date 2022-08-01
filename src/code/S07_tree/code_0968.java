package code.S07_tree;

/**
 * 968. 监控二叉树
 * <p>
 * 给定一个二叉树，我们在树的节点上安装摄像头。
 * 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
 * 计算监控树的所有节点所需的最小摄像头数量。
 * <p>
 * 示例 1：
 * 输入：[0,0,null,0,0]
 * 输出：1
 * 解释：如图所示，一台摄像头足以监控所有节点。
 * 示例 2：
 * 输入：[0,0,null,0,null,0,null,null,0]
 * 输出：2
 * 解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。
 * <p>
 * 提示：
 * 给定树的节点数的范围是[1, 1000]。
 * 每个节点的值都是 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/binary-tree-cameras
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0968 {
    // 节点类型
    private enum NODE_TYPE {
        EMPTY, NOT_MONITORED, MONITORED, CAMERA,
    }

    // 监控个数
    private int count = 0;

    /**
     * time: O(n);      space: O(n)
     *
     * @param root 二叉树根节点
     * @return 所有节点所需的最小摄像头数量
     */
    public int minCameraCover(TreeNode root) {
        NODE_TYPE result = postorder(root);
        return result == NODE_TYPE.NOT_MONITORED ? this.count + 1 : this.count;
    }

    private NODE_TYPE postorder(TreeNode root) {
        if (root == null) return NODE_TYPE.EMPTY;
        NODE_TYPE l = root.left != null ? postorder(root.left) : NODE_TYPE.EMPTY;
        NODE_TYPE r = root.right != null ? postorder(root.right) : NODE_TYPE.EMPTY;
        // 叶子节点
        if (l == NODE_TYPE.EMPTY && r == NODE_TYPE.EMPTY) return NODE_TYPE.NOT_MONITORED;
        // 非叶子节点。因为单子树和双子树的判断条件一样，所以合在一起写
        if (l == NODE_TYPE.NOT_MONITORED || r == NODE_TYPE.NOT_MONITORED) {
            count++;
            return NODE_TYPE.CAMERA;
        } else if (l == NODE_TYPE.CAMERA || r == NODE_TYPE.CAMERA) {
            return NODE_TYPE.MONITORED;
        } else {
            return NODE_TYPE.NOT_MONITORED;
        }
    }
}
