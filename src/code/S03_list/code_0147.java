package code.S03_list;

/**
 * 147. 对链表进行插入排序
 * <p>
 * 给定单个链表的头head，使用 插入排序 对链表进行排序，并返回排序后链表的头。
 * 插入排序算法的步骤:
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 * 下面是插入排序算法的一个图形示例。部分排序的列表(黑色)最初只包含列表中的第一个元素。每次迭代时，
 * 从输入数据中删除一个元素(红色)，并就地插入已排序的列表中。
 * 对链表进行插入排序。
 * <p>
 * 示例 1：
 * 输入: head = [4,2,1,3]
 * 输出: [1,2,3,4]
 * 示例 2：
 * 输入: head = [-1,5,3,4,0]
 * 输出: [-1,0,3,4,5]
 * <p>
 * 提示：
 * 列表中的节点数在 [1, 5000]范围内
 * -5000 <= Node.val <= 5000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/insertion-sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0147 {
  /**
   * 插入排序
   * time: O(n^2);    space: O(1)
   *
   * @param head 链表头结点
   * @return 插入排序后的链表
   */
  public ListNode insertionSortList(ListNode head) {
    ListNode dummy = new ListNode(0, head);
    ListNode head2 = head.next;
    head.next = null;
    // 遍历，插入从第2个节点开始的每一个节点
    while (head2 != null) {
      ListNode newHead2 = head2.next;
      // 找到当前节点在已排序中的位置
      ListNode cur = dummy.next, pre = dummy;
      while (cur != null && cur.val < head2.val) {
        cur = cur.next;
        pre = pre.next;
      }
      head2.next = cur;
      pre.next = head2;
      head2 = newHead2;
    }
    return dummy.next;
  }
}
