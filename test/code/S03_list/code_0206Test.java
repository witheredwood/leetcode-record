package code.S03_list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：[2,1]
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 */
class code_0206Test extends code_0206 {

    @Test
    void testReverseList11() {
        ListNode head = new ListNode(1);
        ListNode p = head;  // 指针
        p.next = new ListNode(2);
        p = p.next;
        p.next = new ListNode(3);
        p = p.next;
        p.next = new ListNode(4);
        p = p.next;
        p.next = new ListNode(5);
        p = reverseList(head);
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }

    @Test
    void testReverseList12() {
        ListNode head = new ListNode(1);
        ListNode p = head;  // 指针
        p.next = new ListNode(2);
        p = reverseList(head);
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }

    @Test
    void testReverseList21() {
        ListNode head = new ListNode(1);
        ListNode p = head;  // 指针
        p.next = new ListNode(2);
        p = p.next;
        p.next = new ListNode(3);
        p = p.next;
        p.next = new ListNode(4);
        p = p.next;
        p.next = new ListNode(5);
        p = reverseList2(head);
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }

    @Test
    void testReverseList22() {
        ListNode head = new ListNode(1);
        ListNode p = head;  // 指针
        p.next = new ListNode(2);
        p = reverseList2(head);
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }
}
