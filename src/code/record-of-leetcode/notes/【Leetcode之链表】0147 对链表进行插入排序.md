# 【Leetcode之链表】0147 对链表进行插入排序

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/insertion-sort-list/

实现语言：Java



##  题目

对链表进行插入排序。

插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。

**插入排序算法：**

1. 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
2. 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
3. 重复直到所有输入数据插入完为止。

**示例**

```
输入: 4->2->1->3
输出: 1->2->3->4

输入: -1->5->3->4->0
输出: -1->0->3->4->5
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
    public ListNode insertionSortList(ListNode head) {
        if (head==null || head.next==null) return head; 
        // add the head node
        ListNode first = new ListNode(0, head);
        head = first;
        ListNode p = head.next.next;
        head.next.next = null;
        ListNode q;
        while (p!=null) {
            ListNode tmp = p.next;
            // find the position
            for (q = head; q.next!=null; q=q.next) {
                if(p.val <= q.next.val) {
                    p.next = q.next;
                    q.next = p;
                    p = tmp;
                    break;
                } 
            }   
            if (q.next==null) {
                p.next = null;      q.next = p;     p = tmp;
            }
        }
        return head.next;
    }
}
```

时间复杂度：O(n^2) 

空间复杂度：O(1)

执行用时：22 ms

内存消耗：38.1 MB

