# 【Leetcode之链表】0021 合并两个有序链表

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/merge-two-sorted-lists/

实现语言：Java



##  题目

将两个升序链表合并为一个新的 **升序** 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

![21](【Leetcode之链表】0021 合并两个有序链表.assets/21.jpg)

**示例**

```
输入：l1 = [1,2,4], l2 = [1,3,4]
输出：[1,1,2,3,4,4]

输入：l1 = [], l2 = []
输出：[]

输入：l1 = [], l2 = [0]
输出：[0]
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;

        // add the head node
        ListNode head = new ListNode(0);
        ListNode r = head;
        // traverse two list
        while(p!=null && q!=null) {
            if (p.val <= q.val) {
				r.next = p;     r = r.next;    p = p.next;
                continue;
            }
            if (p.val > q.val) {
                r.next = q;     r = r.next;     q = q.next;
            }
        }
        while (p!=null) {
            r.next = p;     r = r.next;    p = p.next;
        }
        while (q!=null) {
            r.next = q;     r = r.next;     q = q.next;
        }
        return head.next;
    }
}
```

时间复杂度：O(m+n)  

空间复杂度：O(1)

执行用时：0 ms

内存消耗：37.8 MB

