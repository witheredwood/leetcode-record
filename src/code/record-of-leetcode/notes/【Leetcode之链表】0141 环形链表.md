# 【Leetcode之链表】0141 环形链表

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/linked-list-cycle

实现语言：Java



##  题目

给定一个链表，判断链表中是否有环。

如果链表中有某个节点，可以通过连续跟踪 `next` 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 `pos` 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 `pos` 是 -1，则在该链表中没有环。注意：`pos` 不作为参数进行传递，仅仅是为了标识链表的实际情况。

如果链表中存在环，则返回 `true` 。 否则，返回 `false` 。

**示例**

![21](【Leetcode之链表】0141.assets/21.png)

```
输入：head = [3,2,0,-4], pos = 1
输出：true
解释：链表中有一个环，其尾部连接到第二个节点。
```

![22](【Leetcode之链表】0141.assets/22.png)

```
输入：head = [1,2], pos = 0
输出：true
解释：链表中有一个环，其尾部连接到第一个节点。
```

![23](【Leetcode之链表】0141.assets/23.png)

```
输入：head = [1], pos = -1
输出：false
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
    public boolean hasCycle(ListNode head) {
        if (head==null || head.next==null) return false;
        ListNode fast = head;
        ListNode slow = head;
        // quick node go two steps, slow node go one step
        while (fast!=null && fast.next!=null) {         
            fast=fast.next.next;      slow=slow.next;
            if (fast==slow) return true;
        } 

        return false;       
    }
}
```

时间复杂度：O(n) 

空间复杂度：O(1)

执行用时：0 ms

内存消耗：39.7 MB

