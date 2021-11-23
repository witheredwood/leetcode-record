# 【Leetcode之链表】0203 移除链表元素

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/remove-linked-list-elements/

实现语言：Java



##  题目

给你一个链表的头节点 `head` 和一个整数 `val` ，请你删除链表中所有满足 `Node.val == val` 的节点，并返回 **新的头节点** 。

**示例**

![21](【Leetcode之链表】0203 .assets/21.jpg)

```
输入：head = [1,2,6,3,4,5,6], val = 6
输出：[1,2,3,4,5]

输入：head = [], val = 1
输出：[]

输入：head = [7,7,7,7], val = 7
输出：[]
```

## 方法：模拟

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
    public ListNode removeElements(ListNode head, int val) {
        if (head==null) return head;
        // add the head node
        ListNode first = new ListNode(0, head);
        head = first;
        // traverse the list
        for (ListNode pre=head,cur=head.next; cur!=null; cur = cur.next) {
            // delete the node
            if (cur.val == val) {  
                pre.next = cur.next;                  
            }
            else {
                pre=pre.next;
            }
        }
        return head.next;
    }
}
```

时间复杂度：O(n) 

空间复杂度：O(1)

执行用时：1 ms

内存消耗：39 MB

