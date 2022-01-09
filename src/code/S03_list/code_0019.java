package code.S03_list;

/**
 * 19.删除链表的倒数第N个节点
 * <p>
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *  
 * 提示：
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0019 {
    /**
     * 快慢指针
     *
     * @param head 头结点
     * @param n    正整数
     * @return 删除后的链表头结点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);  // 虚节点
        ListNode fast = dummy;
        // 快指针走 n+1 步
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        ListNode slow = dummy;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 删除 slow 的下一个节点。此时 slow 是要删除的节点的前一个节点
        if (slow != null) slow.next = slow.next.next;
        return dummy.next;
    }
}
