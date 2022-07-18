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
 * <p>
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
   * 快慢指针，要删除倒数第 n 个节点，需要找到倒数第 (n+1) 个节点
   * time: O(n);    space: O(1)
   *
   * @param head 头结点
   * @param n    正整数，其值在链表节点总数之内
   * @return 删除后的链表头结点
   */
  public ListNode removeNthFromEnd31(ListNode head, int n) {
    // 加入虚结点
    ListNode dummy = new ListNode(-1, head);
    head = dummy;
    // 快指针先走n+1步（找到删除节点的前一个节点）
    ListNode fast = head;
    for (int i = 0; i <= n; i++) {
      fast = fast.next;
    }
    // 快慢指针同时走，直到快指针走到最后
    ListNode slow = head;
    while (fast != null) {
      slow = slow.next;
      fast = fast.next;
    }
    // 删除慢指针后的节点（如果存在的话）
    if (slow.next != null) {
      slow.next = slow.next.next;
    } else {
      slow.next = null;
    }
    return head.next;
  }

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
