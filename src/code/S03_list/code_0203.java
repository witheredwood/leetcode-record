package code.S03_list;

/**
 * 203.移除链表元素
 * <p>
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 示例 2：
 * 输入：head = [], val = 1
 * 输出：[]
 * 示例 3：
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-linked-list-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0203 {
  /**
   * 删除链表元素
   * time: O(n);    space: O(1)
   *
   * @param head 链表头结点
   * @param val  整数
   * @return 删除整数 val 之后的链表头结点
   */
  public ListNode removeElements31(ListNode head, int val) {
    ListNode dummy = new ListNode(0, head);
    for (ListNode pre = dummy, cur = dummy.next; cur != null; cur = cur.next) {
      if (val == cur.val) {
        pre.next = cur.next;
      } else {
        pre = pre.next;
      }
    }
    return dummy.next;
  }

  /**
   * @param head 链表头结点
   * @param val  整数
   * @return 删除整数 val 之后的链表头结点
   */
  public ListNode removeElements(ListNode head, int val) {
    if (head == null) return head;
    ListNode dummy = new ListNode(-1, head);  // 设置虚节点
    System.out.println("node = " + dummy.val + " head = " + dummy.next.val);
    ListNode p = dummy;
    while (p != null && p.next != null) {
      if (val == p.next.val) {
        p.next = p.next.next;
      } else {
        p = p.next;
      }
    }
    return dummy.next;
  }

  /**
   * @param head 链表头结点
   * @param val  整数
   * @return 删除整数 val 之后的链表头结点
   */
  public ListNode removeElements2(ListNode head, int val) {
    if (head == null) return head;
    ListNode dummy = new ListNode(-1, head);  // 设置虚节点
    System.out.println("node = " + dummy.val + " head = " + dummy.next.val);
    for (ListNode pre = dummy, cur = head; cur != null; cur = cur.next) {
      if (val == cur.val) {
        pre.next = cur.next;
      } else {
        pre = pre.next;
      }
    }
    return dummy.next;
  }
}
