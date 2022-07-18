package code.S03_list;

/**
 * 24. 两两交换链表中的节点
 * <p>
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 * 输入：head = [1]
 * 输出：[1]
 * <p>
 * 提示：
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0024 {
  /**
   * time: O(n);    space: O(1)
   *
   * @param head 头结点
   * @return 交换后的链表头结点
   */
  public ListNode swapPairs31(ListNode head) {
    // 加入虚节点
    ListNode dummy = new ListNode(0, head);
    head = dummy;
    // 遍历变量
    ListNode last = head;  // 已排过序的链表的最后一个节点
    ListNode p1 = head.next, p2 = null;  // 要交换的相邻的节点
    ListNode start;  // 未交换的链表的第1个节点
    while (p1 != null && p1.next != null) {
      p2 = p1.next;
      // 交换相邻节点
      start = p2.next;
      p2.next = p1;
      p1.next = start;
      // 加入已排过序的链表中
      last.next = p2;
      // 更新遍历变量
      last = last.next.next;
      p1 = start;
    }
    last.next = p1;
    return head.next;
  }

  /**
   * @param head 头结点
   * @return 交换后的链表头结点
   */
  public ListNode swapPairs(ListNode head) {
    ListNode dummy = new ListNode(); // 虚节点
    dummy.next = head;
    ListNode first = head, second, tmp = null;
    ListNode p = dummy;
    while (first != null) {
      second = first.next;
      if (second != null) {
        tmp = second.next;
        p.next = second;
        p = p.next;
      } else {
        tmp = null;
      }
      p.next = first;
      p = p.next;
      p.next = null;
      first = tmp;
    }
    System.out.println("duumy = " + dummy.next.val);
    return dummy.next;
  }

  /**
   * @param head 头结点
   * @return 交换后的链表头结点
   */
  public ListNode swapPairs2(ListNode head) {
    ListNode dummy = new ListNode(); // 虚节点
    dummy.next = head;
    ListNode pre = dummy, first = head, second, tmp;
    while (first != null && first.next != null) {
      // 变量
      second = first.next;
      tmp = second.next;
      // 交换
      pre.next = second;
      second.next = first;
      first.next = tmp;
      // 移动引用
      first = tmp;
      pre = pre.next.next;
    }
    pre.next = first;
    System.out.println("duumy = " + dummy.next.val);
    return dummy.next;
  }
}
