package code.S03_list;

import java.util.LinkedList;

/**
 * 143. 重排链表
 * <p>
 * 定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[1,4,2,3]
 * 示例 2：
 * 输入：head = [1,2,3,4,5]
 * 输出：[1,5,2,4,3]
 * <p>
 * 提示：
 * 链表的长度范围为 [1, 5 * 10^4]
 * 1 <= node.val <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0143 {
  /**
   * 使用队列存放链表的前一半，使用栈存放链表的后一半
   * time: O(n);    space: O(n)
   *
   * @param head 头节点
   */
  public void reorderList32(ListNode head) {
    // 找到链表的中点
    ListNode dummy = new ListNode(0, head);
    ListNode p1 = dummy, p2 = dummy;   // p1 是第2部分的起始节点
    while (p2 != null && p2.next != null) {
      p1 = p1.next;
      p2 = p2.next.next;
    }
    p1 = p1.next;
    // 分为两部分存储
    LinkedList<ListNode> queue = new LinkedList<>();
    for (ListNode p = head; p != p1; p = p.next) {
      queue.offer(p);
    }
    queue.peekLast().next = null;
    LinkedList<ListNode> stack = new LinkedList<>();
    for (ListNode p = p1; p != null; p = p.next) {
      stack.push(p);
    }
    // 合并队列和栈中的节点
    ListNode resultHead = new ListNode();
    ListNode last = resultHead;
    while (!queue.isEmpty() && !stack.isEmpty()) {
      last.next = queue.poll();
      last.next.next = stack.pop();
      last = last.next.next;
    }
    if (!queue.isEmpty()) {
      last.next = queue.pop();
    } else {
      last.next = null;
    }
    head = resultHead.next;
  }

  /**
   * 重排链表
   * time: O(n);    space: O(1)
   *
   * @param head 头节点
   */
  public void reorderList31(ListNode head) {
    // 找到链表的中点
    ListNode dummy = new ListNode(0, head);
    ListNode last = dummy, last2 = dummy;  // last 是前一半链表的最后一个节点
    while (last2 != null && last2.next != null) {
      last = last.next;
      last2 = last2.next.next;
    }
    System.out.println(last.val);
    // 倒排head2为起点（不算head2）的链表
    ListNode head2 = inverted(last.next);
    last.next = null;   // 前一半链表的最后置空，防止形成环
    // 合并2个链表
    ListNode p = dummy, p1 = head, p2 = head2;
    ListNode start1 = null, start2 = null;
    while (p1 != null && p2 != null) {
      start1 = p1.next;
      start2 = p2.next;

      p.next = p1;
      p1.next = p2;

      p1 = start1;
      p2 = start2;
      p = p.next.next;
    }
    if (p1 != null) {
      p.next = p1;
    } else {
      p.next  = null;
    }
  }

  /**
   * 倒排链表
   * 如链表 [1,2,3,4] 变为 [4,3,2,1]
   * time: O(n);    space； O(1)
   *
   * @param head 头节点
   * @return 倒排后的链表
   */
  private ListNode inverted(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode dummy = new ListNode(0, head);
    ListNode p = head.next;
    head.next = null;
    ListNode start = null;
    while (p != null) {
      start = p.next;
      dummy.next = p;
      p.next = head;
      head = p;
      p = start;
    }
    return head;
  }
}
