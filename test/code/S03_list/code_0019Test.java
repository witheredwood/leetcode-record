package code.S03_list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 */
class code_0019Test extends code_0019 {

    @Test
    void testRemoveNthFromEnd11() {
        ListNode head = new ListNode(1);
        ListNode p = head;  // 指针
        p.next = new ListNode(2);
        p = p.next;
        p.next = new ListNode(3);
        p = p.next;
        p.next = new ListNode(4);
        p = p.next;
        p.next = new ListNode(5);
        p = removeNthFromEnd(head, 2);
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }

    @Test
    void testRemoveNthFromEnd12() {
        ListNode head = new ListNode(1);
        ListNode p = removeNthFromEnd(head, 1);
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }

    @Test
    void testRemoveNthFromEnd13() {
        ListNode head = new ListNode(1);
        ListNode p = head;  // 指针
        p.next = new ListNode(2);
        p = removeNthFromEnd(head, 1);
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }

}
