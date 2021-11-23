# 【Leetcode之链表】0024 两两交换链表中的节点

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs/

实现语言：Java

<!-- MarkdownTOC -->

- 题目
- 

<!-- /MarkdownTOC -->

##  题目

给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

**你不能只是单纯的改变节点内部的值**，而是需要实际的进行节点交换。

![22](【Leetcode之链表】0024 两两交换链表中的节点.assets/22.jpg)

**示例**

```
输入：head = [1,2,3,4]
输出：[2,1,4,3]

输入：head = []
输出：[]

输入：head = [1]
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
    public ListNode swapPairs(ListNode head) {
        if (head==null || head.next==null) return head;
        // add the head node
        ListNode first = new ListNode(0, head);
        head = first;
        ListNode front = head.next;
        ListNode rear = head;
        //  traverse the list
        while (front!=null && front.next!=null) {
            rear.next = front.next;
            front.next = rear.next.next;
            rear.next.next = front;
            
            front = front.next;
            rear = rear.next.next;
        }

        return head.next;
    }
}
```

时间复杂度：O(n)  

空间复杂度：O(1)

执行用时：0 ms

内存消耗：36.2 MB

