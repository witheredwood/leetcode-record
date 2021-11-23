# 【Leetcode之链表】0237 删除链表中的节点

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/delete-node-in-a-linked-list

实现语言：Java



##  题目

请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 **要被删除的节点** 。

现有一个链表 -- head = [4,5,1,9]，它可以表示为:

![21](【Leetcode之链表】0237 .assets/21.png)

**示例**

```
输入：head = [4,5,1,9], node = 5
输出：[4,1,9]
解释：给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.

输入：head = [4,5,1,9], node = 1
输出：[4,5,9]
解释：给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
```

- 链表至少包含两个节点。

- 链表中所有节点的值都是唯一的。

- 给定的节点为非末尾节点并且一定是链表中的一个有效节点。

- 不要从你的函数中返回任何结果。

  

## 方法：原链表删除

**代码实现**

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {   
        // the next node of the node to be delete     
        ListNode tmp = node.next; 
        // swap the value of node and tmp
        int value = node.val;
        node.val = tmp.val;
        tmp.val = value;
        // delete the next node to be delete
        node.next = tmp.next;
    }
}
```

时间复杂度：O(1) 

空间复杂度：O(1)

执行用时：0 ms

内存消耗：37.9 MB

