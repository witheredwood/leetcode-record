package code.S03_list;

/**
 * 141. 环形链表
 * <p>
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 注意：pos 不作为参数进行传递。仅仅是为了标识链表的实际情况。
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 * <p>
 * 提示：
 * 链表中节点的数目范围是 [0, 10^4]
 * -10^5 <= Node.val <= 10^5
 * pos 为 -1 或者链表中的一个 有效索引 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0141 {
  /**
   * 快慢指针：慢指针每次走 1 步，快指针每次走 2 步
   * time: O(n);    space: O(1)
   * 时间复杂度：
   * 1）当链表中不存在环时，快指针将先于慢指针到达链表尾部，链表中每个节点至多被访问两次。
   * 2）当链表中存在环时，每一轮移动后，快慢指针的距离将减小一。而初始距离为环的长度，因此至多移动 NN 轮。
   *
   * @param head 头节点
   * @return 链表是否有环
   */
  public boolean hasCycle(ListNode head) {
    // 加入虚节点，方便处理空链表的情况
    ListNode dummy = new ListNode(0, head);
    head = dummy;
    // 使用双指针遍历。由于有环的跳出循环的条件是 fast = slow，所以初始条件不能设置slow / fast指向同一个节点
    ListNode slow = head, fast = head.next;
    while (fast != null && fast.next != null && fast.next.next != null && fast != slow) {
      fast = fast.next.next;
      slow = slow.next;
    }
    if (fast == slow) return true;
    return false;
  }
}
