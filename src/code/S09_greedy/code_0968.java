package code.S09_greedy;

import code.S07_tree.TreeNode;

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
 * 给定树的节点数的范围是 [1, 1000]。
 * 每个节点的值都是 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-cameras
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0968 {
    int num = 0;

    /**
     * @param root 二叉树根节点
     * @return 放置摄像头的个数
     */
    public int minCameraCover(TreeNode root) {
        if (root.left == null && root.right == null) return 1;
        int c = traverse(root);
        System.out.println("c = " + c + " num = " + num);
        if (c == 0) num++;
        return num;
    }

    /**
     * 二叉树中的节点有4中状态：0 - 无监控，1 - 被监控，2 - 摄像头
     * -------
     * 空节点是有监控状态
     * -------
     * 左右子节点都是有监控状态，那么该节点是无监控状态，在该节点的父节点放置摄像头；
     * -------
     * 其余情况需要放置摄像头；
     *
     * @param root 二叉树根节点
     * @return 该节点的状态
     */
    public int traverse(TreeNode root) {
        if (root == null) return 1;  // 空节点是有监控状态
        int l = traverse(root.left);
        int r = traverse(root.right);
        // 两个子节点都是有监控状态，那么当前节点是无监控状态，在当前节点的父节点安装摄像头
        if (l == 1 && r == 1) return 0;
        // 该节点被监控的情况，子节点中有一个是摄像头
        if ((l == 2 && r != 0) || (r == 2 && l != 0)) return 1;
        num++;
        return 2;
    }
}
