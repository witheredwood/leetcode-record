package code.S03_list;

import java.util.LinkedList;

/**
 * 206.反转链表
 * <p>
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：[2,1]
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 * <p>
 * 提示：
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 */
public class code_0206 {
  /**
   * @param head 链表的头节点
   * @return 反转后的链表的头结点
   */
  public ListNode reverseList31(ListNode head) {
    ListNode dummy = new ListNode(0, null);
    ListNode cur = head, newHead = null;
    while (cur != null) {
       newHead = cur.next;
      cur.next = dummy.next;
      dummy.next = cur;
      cur = newHead;
    }
    return dummy.next;
  }

  /**
   * @param head 头节点
   * @return 反转后的链表的头结点
   */
  public ListNode reverseList(ListNode head) {
    if (head == null) return head;
    ListNode yummy = new ListNode();  // 虚节点
    yummy.next = head;
    ListNode p = head.next, q;  // 引用
    head.next = null;
    while (p != null) {
      q = p.next;  // 保存
      p.next = yummy.next;
      yummy.next = p;
      p = q;
    }
    System.out.println("head = " + yummy.next.val);
    return yummy.next;
  }

  /**
   * @param head 头节点
   * @return 反转后的链表的头结点
   */
  public ListNode reverseList2(ListNode head) {
    ListNode pre = null, cur = head, tmp;  // 引用
    while (cur != null) {
      tmp = cur.next;  // 暂时保存cur的下一个节点
      cur.next = pre;  // 保存
      pre = cur;
      cur = tmp;
    }
    System.out.println("head = " + pre.val);
    return pre;
  }
}
