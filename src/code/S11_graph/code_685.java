package code.S11_graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 685. 冗余连接 II
 * <p>
 * 在本问题中，有根树指满足以下条件的 有向 图。该树只有一个根节点，所有其他节点都是该根节点的后继。
 * 该树除了根节点之外的每一个节点都有且只有一个父节点，而根节点没有父节点。
 * 输入一个有向图，该图由一个有着 n 个节点（节点值不重复，从 1 到 n）的树及一条附加的有向边构成。
 * 附加的边包含在 1 到 n 中的两个不同顶点间，这条附加的边不属于树中已存在的边。
 * 结果图是一个以边组成的二维数组edges 。 每个元素是一对 [ui, vi]，用以表示 有向 图中连接顶点 ui 和顶点 vi 的边，其中 ui 是 vi 的一个父节点。
 * 返回一条能删除的边，使得剩下的图是有 n 个节点的有根树。若有多个答案，返回最后出现在给定二维数组的答案。
 * <p>
 * 示例 1：
 * 输入：edges = [[1,2],[1,3],[2,3]]
 * 输出：[2,3]
 * 示例 2：
 * 输入：edges = [[1,2],[2,3],[3,4],[4,1],[1,5]]
 * 输出：[4,1]
 * <p>
 * 提示：
 * n == edges.length
 * 3 <= n <= 1000
 * edges[i].length == 2
 * 1 <= ui, vi <= n
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/redundant-connection-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_685 {
    /**
     * @param edges 二维数组
     * @return 要删除的一条边
     */
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int vexNumber = edges.length;
        //判断父节点是否有2个
        int[] adj = new int[vexNumber + 1];
        int[] edge1 = null, edge2 = null;
        // 寻找是否有一个节点有2个父节点
        for (int i = 0; i < edges.length; i++) {
            int parent = edges[i][0], child = edges[i][1];
            if (adj[child] != 0) {      // 有一个节点有2个父节点
                edge1 = new int[]{adj[child], child};       // 位置较前的边
                edge2 = new int[]{parent, child};       // 位置较后的边
            } else {
                adj[child] = parent;
            }
        }
        // 如果有两个父节点，删除其中一条边
        if (edge1 != null && edge2 != null) {
            if (isTree(edges, edge2)) return edge2;
            return edge1;
        }
        // 如果没有节点有2个父节点，那么一定有环，删除环中最后出现的一条边
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < edges.length; i++) {
            int parent = edges[i][0], child = edges[i][1];
            if (set.contains(child) && set.contains(parent)) return edges[i];
            set.add(parent);
            set.add(child);
        }
        return new int[]{};
    }

    /**
     * 判断一个二维数组存放的所有边是否能组成一棵树
     *
     * @param nums       二维数组，存放有向边
     * @param removeEdge 要删除的一条边
     * @return 该数组存放的所有边是否能组成一棵树
     */
    private boolean isTree(int[][] nums, int[] removeEdge) {
        int[] adj = new int[nums.length + 1];
        for (int[] edge : nums) {
            if (Arrays.equals(removeEdge, edge)) continue;
            int parent = findRoot(adj, edge[0]);
            if (parent == edge[1]) return false;    // 有环，一定不是树
            adj[edge[1]] = edge[0];
        }
        return true;
    }

    /**
     * 找到某个节点的祖宗节点
     *
     * @param adj   孩子-父母表
     * @param child 孩子节点
     * @return 该孩子节点的祖宗节点
     */
    private int findRoot(int[] adj, int child) {
        int index = child;
        int parent = 0;
        while (adj[index] != 0) {
            parent = adj[index];
            index = parent;
        }
        return parent;
    }
}
