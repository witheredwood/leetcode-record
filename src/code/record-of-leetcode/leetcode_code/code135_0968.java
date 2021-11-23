package leetcode_code;


// 968. 监控二叉树
public class code135_0968 {

//    [0,0,null,0,0]
//    [0,0,null,0,null,0,null,null,0]
//    [0]
//    [0,0,0,null,0,null,0]
//    [0,0,0,null,null,null,0]
//    [0,0,null,null,0,0,null,null,0,0]

    int num = 0;
    public int minCameraCover(TreeNode root) {
        traverse(root);
        return num;
    }

    // 节点状态：0-无覆盖；1-有覆盖；2-有摄像头
    public int traverse (TreeNode root) {
        // 空节点 ==> 有覆盖
        if (root==null) return 1;

        int l = traverse(root.left);
        int r = traverse(root.right);

        // 2个子节点都是有覆盖 ==> 无覆盖
        if (l==1 && r==1) return 0;

        // 2个子节点都是摄像头 ==> 有覆盖
        if (l==2 && r==2) return 1;
        // 1个子节点是摄像头，1个节点是有覆盖 ==> 有覆盖
        if ((l==2 && r==1) ||( l==1 && r==2 )) return 1;

        // 其余情况是有摄像头
        num++;
        return 2;
//        // 1个子节点无覆盖，1个节点是有覆盖 ==> 摄像头
//        if ((l==0 && r==1) ||( l==1 && r==0 )) return 2;
//        // 1个子节点是摄像头，1个节点是无覆盖 ==> 摄像头
//        if ((l==2 && r==0) || (l==0 && r==2)) return 2;
//        // 2个子节点都是无覆盖 ==> 摄像头
//        if (1==0 && r==0) return 2;
    }

}
