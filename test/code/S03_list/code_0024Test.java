package code.S03_list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 * 输入：head = [1]
 * 输出：[1] */
class code_0024Test extends code_0024 {

    @Test
    void testSwapPairs11() {
        ListNode head = new ListNode(1);
        ListNode p = head;  // 指针
        p.next = new ListNode(2);
        p = p.next;
        p.next = new ListNode(3);
        p = p.next;
        p.next = new ListNode(4);
        p = swapPairs(head);
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }

    @Test
    void testSwapPairs12() {
        ListNode head = new ListNode();
        ListNode p = swapPairs(head);
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }

    @Test
    void testSwapPairs13() {
        ListNode head = new ListNode(1);
        ListNode p = head;  // 指针
        p = swapPairs(head);
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }

    @Test
    void testSwapPairs14() {
        ListNode head = new ListNode(1);
        ListNode p = head;  // 指针
        p.next = new ListNode(2);
        p = p.next;
        p.next = new ListNode(3);
        p = swapPairs(head);
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }

    @Test
    void testSwapPairs21() {
        ListNode head = new ListNode(1);
        ListNode p = head;  // 指针
        p.next = new ListNode(2);
        p = p.next;
        p.next = new ListNode(3);
        p = p.next;
        p.next = new ListNode(4);
        p = swapPairs2(head);
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }

    @Test
    void testSwapPairs22() {
        ListNode head = new ListNode();
        ListNode p = swapPairs2(head);
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }

    @Test
    void testSwapPairs23() {
        ListNode head = new ListNode(1);
        ListNode p = head;  // 指针
        p = swapPairs2(head);
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }

    @Test
    void testSwapPairs24() {
        ListNode head = new ListNode(1);
        ListNode p = head;  // 指针
        p.next = new ListNode(2);
        p = p.next;
        p.next = new ListNode(3);
        p = swapPairs2(head);
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }
}
