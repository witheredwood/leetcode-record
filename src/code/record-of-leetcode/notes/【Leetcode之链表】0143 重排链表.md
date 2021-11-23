# 【Leetcode之链表】0143 重排链表

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/reorder-list

实现语言：Java



##  题目

给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

**示例**

```
给定链表 1->2->3->4, 重新排列为 1->4->2->3.

给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
```

## 方法：双指针（快慢指针）

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
    public void reorderList(ListNode head) {
        if (head==null || head.next==null) return ;
        // find the second half of the list
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
       
        //reverse the second of the list
        ListNode head2 = slow.next;
        slow.next = null;
        head2 = reverse(head2);
        // merge
        merge(head, head2);     
    }
    // no head node
    public void merge(ListNode head, ListNode head2) {
        ListNode p = head;
        ListNode q = head2;
        ListNode tmp;
        while (p!=null && q!=null) {
            tmp = q.next;
            q.next = p.next;
            p.next = q;
            p = p.next.next;
            q = tmp;
        }
    }
    // no head node
    public ListNode reverse(ListNode head) {
       if (head==null || head.next==null) return head;
       ListNode p = head.next;
       head.next = null;
       ListNode tmp;
       while (p!=null){
           tmp = p.next;
           p.next = head;
           head = p;
           p = tmp;
       }
       return head;
    }
}
```

时间复杂度：O(n) 

空间复杂度：O(1)

执行用时：2 ms

内存消耗：41.2 MB

