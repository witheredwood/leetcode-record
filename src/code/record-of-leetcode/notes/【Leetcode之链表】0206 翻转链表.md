# 【Leetcode之链表】0206 翻转链表

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/reverse-linked-list/

实现语言：Java



##  题目

反转一个单链表。

**示例**

```
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
```

## 方法：头插法

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
    public ListNode reverseList(ListNode head) {
        if (head==null || head.next==null) return head;
        // add the head node
        ListNode first = new ListNode(0, head);
        head = first;

        // traverse the list
        ListNode p = head.next.next;
        head.next.next = null;
        ListNode tmp;
        while (p!=null) {
            tmp = p.next;
            p.next = head.next;
            head.next = p;
            p = tmp;
        }
        return head.next;
    }
}
```

时间复杂度：O(n) 

空间复杂度：O(1)

执行用时：0 ms

内存消耗：37.6 MB

