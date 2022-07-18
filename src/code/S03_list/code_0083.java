package code.S03_list;

/**
 * 83. 删除排序链表中的重复元素
 * <p>
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 * <p>
 * 示例 1：
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * 示例 2：
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 * <p>
 * 提示：
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0083 {
  /**
   * time: O(n);    space: O(1)
   *
   * @param head 头节点
   * @return 去除重复节点的链表
   */
  public ListNode deleteDuplicates(ListNode head) {
    // 空链表单独处理
    if (head == null) return null;
    // 遍历，取出不重复的节点组成最终的节点
    ListNode last = head;
    for (ListNode p = head.next; p != null; p = p.next) {
      if (last.val != p.val) {
        last.next = p;
        last = last.next;
      }
    }
    // 最终的链表记得置空
    last.next = null;
    return head;
  }
}
