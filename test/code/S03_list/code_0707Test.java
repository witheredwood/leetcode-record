package code.S03_list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 示例：
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
 * linkedList.get(1);            //返回2
 * linkedList.deleteAtIndex(1);  //现在链表是1-> 3
 * linkedList.get(1);            //返回3
 */
class code_0707Test {
    @Test
    void test() {
        code_0707 linkedList = new code_0707();
        linkedList.toString();
        linkedList.addAtHead(1);
        System.out.println(linkedList.toString());
        linkedList.addAtTail(3);
        System.out.println(linkedList.toString());
        linkedList.addAtIndex(1, 2);   //链表变为1-> 2-> 3
        System.out.println(linkedList.toString());
        int value = linkedList.get(1);            //返回2
        System.out.println("get(1) = " + value);
        System.out.println(linkedList.toString());
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        System.out.println(linkedList.toString());
        value = linkedList.get(1);            //返回3
        System.out.println("get(1) = " + value);
        System.out.println(linkedList.toString());
    }
}
