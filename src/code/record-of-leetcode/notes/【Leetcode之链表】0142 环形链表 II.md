# 【Leetcode之链表】0142 环形链表 II

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/linked-list-cycle-ii/

实现语言：Java



##  题目


给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 `null`。

为了表示给定链表中的环，我们使用整数 `pos` 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 `pos` 是 `-1`，则在该链表中没有环。**注意，`pos` 仅仅是用于标识环的情况，并不会作为参数传递到函数中。**

**说明：**不允许修改给定的链表。

**示例**

![21](【Leetcode之链表】0141.assets/21.png)

```
输入：head = [3,2,0,-4], pos = 1
输出：返回索引为 1 的链表节点
解释：链表中有一个环，其尾部连接到第二个节点。
```

![22](【Leetcode之链表】0141.assets/22.png)

```
输入：head = [1,2], pos = 0
输出：返回索引为 0 的链表节点
解释：链表中有一个环，其尾部连接到第一个节点。
```

![23](【Leetcode之链表】0141.assets/23.png)

```
输入：head = [1], pos = -1
输出：返回 null
解释：链表中没有环。
```

## 方法：双指针（快慢指针）

**代码实现**

```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head==null || head.next==null) return null;
        ListNode fast = head;
        ListNode slow = head;
        // find the node in the ring
        while (fast.next!=null && fast.next.next!=null) {
            fast = fast.next.next;      slow = slow.next;
            if(fast==slow)  break;
        }   
        if (fast.next==null || fast.next.next==null) return null;
        // find the entry node of the ring
        ListNode p = head;
        while (p!=slow) {
            p = p.next;     slow = slow.next;
        }
        return p;
    }
}
```

时间复杂度：O(n) 

空间复杂度：O(1)

执行用时：0 ms

内存消耗：38.5 MB

