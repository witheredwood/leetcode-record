package code.S03_list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 示例 1：
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 示例 2：
 * 输入：head = [], val = 1
 * 输出：[]
 * 示例 3：
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 */
class code_0203Test extends code_0203 {
    @Test
    void testRemoveElements() {
        ListNode head1 = new ListNode(1);
        ListNode p = head1;  // 指针
        p.next = new ListNode(2);
        p = p.next;
        p.next = new ListNode(3);
        p = p.next;
        p.next = new ListNode(4);
        p = p.next;
        p.next = new ListNode(5);
        p = p.next;
        p.next = new ListNode(6);
        int val1 = 6;
        p = removeElements(head1, val1);
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }

    @Test
    void testRemoveElements2() {
        ListNode head1 = new ListNode(7);
        ListNode p = head1;  // 指针
        p.next = new ListNode(7);
        p = p.next;
        p.next = new ListNode(7);
        p = p.next;
        p.next = new ListNode(7);
        p = p.next;
        p.next = new ListNode(7);
        p = p.next;
        p.next = new ListNode(7);
        int val1 = 7;
        p = removeElements(head1, val1);
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }
}
