# 【Leetcode之链表】0083 删除排序链表中的重复元素

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/

实现语言：Java



##  题目

给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

**示例**

```
输入: 1->1->2
输出: 1->2

输入: 1->1->2->3->3
输出: 1->2->3
```

## 方法：遍历

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
    public ListNode deleteDuplicates(ListNode head) {      
        if (head==null || head.next==null) return head;
        ListNode pre = head;  // the previous node to be delete
        ListNode cur = head.next;  // the node to be delete
        // traverse the list
        while (cur!=null) {
            // delete the duplicate value
            if (cur.val == pre.val) {
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
            cur = cur.next;
        } 
        return head;
    }
}
```

时间复杂度：O(n) 

空间复杂度：O(1)

执行用时：0 ms

内存消耗：38.1 MB

