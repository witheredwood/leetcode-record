# 【Leetcode之链表】0019 删除链表的倒数第 N 个结点

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/

实现语言：Java



##  题目

给你一个链表，删除链表的倒数第 `n` 个结点，并且返回链表的头结点。

![21](【Leetcode之链表】0019 删除链表的倒数第 N 个结点 .assets/21.jpg)

**示例**

```
输入：head = [1,2,3,4,5], n = 2
输出：[1,2,3,5]

输入：head = [1], n = 1
输出：[]

输入：head = [1,2], n = 1
输出：[1]
```

## 方法：双指针法（快慢指针）

**代码实现**

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // add head node
        ListNode first = new ListNode(0,head);
        head = first;  // head points to the first node

        ListNode cur = first;  // cur node is similar to a C++ points 
        ListNode pre = first;  // the next node is the node to be delete
        // the current node first go n steps
        for (int count=0; count<n; count++) {
            if (cur==null) return head.next;
            cur = cur.next;
        }
        // the current node go to the last node of the list
        while (cur.next!=null) {
            cur = cur.next;
            pre = pre.next;
        }
        // delete the next node of the pre node
        pre.next = pre.next.next;
        return head.next;

    }
}
```

时间复杂度：O(n)  

空间复杂度：O(1)

执行用时：0 ms

内存消耗：36.3 MB

