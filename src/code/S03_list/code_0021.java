package code.S03_list;

/**
 * 21. 合并两个有序链表
 * <p>
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例 1：
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 * <p>
 * 提示：
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0021 {
  /**
   * time: O(n+m);    space:O(1)
   *
   * @param list1 升序链表1
   * @param list2 升序链表2
   * @return 合并后的升序链表
   */
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    // 头节点
    ListNode head = new ListNode();
    ListNode last = head;
    // 2个链表均不空时，合并
    while (list1 != null && list2 != null) {
      if (list1.val <= list2.val) {
        last.next = list1;
        list1 = list1.next;
      } else {
        last.next = list2;
        list2 = list2.next;
      }
      last = last.next;
    }
    // 若1个链表未空，则将另一个链表并入最终链表的最后
    if (list1 == null) {
      last.next = list2;
    } else {
      last.next = list1;
    }
    return head.next;
  }
}
