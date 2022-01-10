package code.S03_list;

/**
 * 142.环形链表II
 * <p>
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 不允许修改 链表。
 * <p>
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：返回索引为 0 的链表节点
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：返回 null
 * 解释：链表中没有环。
 * <p>
 * 提示：
 * 链表中节点的数目范围在范围 [0, 10^4] 内
 * -10^5 <= Node.val <= 10^5
 * pos 的值为 -1 或者链表中的一个有效索引
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0142 {
    /**
     * 慢指针每次走一步，快指针每次走一步。如果有环，两个指针一定会在环中相遇。（快指针相对于慢指针，是每次走一步）
     * 从头结点出发一个指针，从相遇节点 也出发一个指针，这两个指针每次只走一个节点， 那么当这两个指针相遇的时候就是 环形入口的节点。
     * @param head 链表的头结点
     * @return 链表中有环，则返回进入环的第一个节点。链表中无环，则返回 null
     */
    public ListNode detectCycle(ListNode head) {
        ListNode dummy = new ListNode(0, head);  // 虚节点
        ListNode slow = dummy.next, fast = dummy.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){  // 第一次相遇
                // 寻找入口
                System.out.println("slow = " + slow.val + " fast = " + fast.val);
                ListNode p1 = head, p2 = fast;
                while (p1 != p2) {
                    p1 = p1.next;
                    p2 = p2.next;
                }
                return p1;
            }
        }
        // 寻找入口
        if (slow == fast) {

        }
        return null;
    }
}
