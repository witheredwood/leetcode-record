package code.S03_list;

/**
 * 面试题 02.07. 链表相交
 * <p>
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * 图示两个链表在节点 c1 开始相交：
 * 题目数据 保证 整个链式结构中不存在环。
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 * <p>
 * 示例 1：
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Intersected at '8'
 * 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
 * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * 示例 2：
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Intersected at '2'
 * 解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。
 * 在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 * 示例 3：
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
 * 由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 这两个链表不相交，因此返回 null 。
 * <p>
 * 提示：
 * listA 中节点数目为 m
 * listB 中节点数目为 n
 * 0 <= m, n <= 3 * 104
 * 1 <= Node.val <= 105
 * 0 <= skipA <= m
 * 0 <= skipB <= n
 * 如果 listA 和 listB 没有交点，intersectVal 为 0
 * 如果 listA 和 listB 有交点，intersectVal == listA[skipA + 1] == listB[skipB + 1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0207 {
    /**
     * @param headA 第一个链表的头结点
     * @param headB 第二个链表的头结点
     * @return 两个链表相交的节点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 计算链表长度
        int lenA = 0, lenB = 0;
        for (ListNode p = headA; p != null; p = p.next) {
            lenA++;
        }
        for (ListNode p = headB; p != null; p = p.next) {
            lenB++;
        }
        System.out.println("lenA = " + lenA + " lenB = " + lenB);
        if (lenA == 0 || lenB == 0) return new ListNode();
        ListNode dummyA = new ListNode(0, headA);
        ListNode dummyB = new ListNode(0, headB);
        ListNode pa = dummyA, pb = dummyB;
        System.out.println("pa = " + pa.next.val + " pb = " + pb.next.val);
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                pa = pa.next;
            }
        } else {
            for (int i = 0; i < lenB - lenA; i++) {
                pb = pb.next;
            }
        }
        System.out.println("pa = " + pa.next.val + " pb = " + pb.next.val);
        while (pa != pb && pa != null && pb != null) {
            pa = pa.next;
            pb = pb.next;
        }
        return pa;
    }
}
