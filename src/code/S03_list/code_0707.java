package code.S03_list;

import java.util.LinkedList;

/**
 * 707.设计链表
 * <p>
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。
 * val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。
 * 假设链表中的所有节点都是 0-index 的。
 * 在链表类中实现这些功能：
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 * <p>
 * 示例：
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
 * linkedList.get(1);            //返回2
 * linkedList.deleteAtIndex(1);  //现在链表是1-> 3
 * linkedList.get(1);            //返回3
 * <p>
 * 提示：
 * 所有val值都在 [1, 1000] 之内。
 * 操作次数将在  [1, 1000] 之内。
 * 请不要使用内置的 LinkedList 库。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0707 {
    /**
     * 链表节点
     */
    class Node {
        int val;  // 节点中存储的值
        Node next;  // 指向下一个节点

        Node() {
        }

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    Node head;
    int size;

    public code_0707() {
        head = new Node();  // 加入一个虚节点
        size = 0;
    }

    /**
     * 获取链表中第 index 个节点的值。如果索引无效，则返回-1。
     *
     * @param index 节点索引
     * @return 该节点的值
     */
    int get(int index) {
        if (index < 0 || index >= size) return -1;
        Node p = head;
        for (int i = 0; i <= index; i++) {
            p = p.next;
        }
        return p.val;
    }

    /**
     * 头插法。在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
     *
     * @param val 整数
     */
    void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /**
     * 尾插法。将值为 val 的节点追加到链表的最后一个元素。
     *
     * @param val 整数
     */
    void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /**
     * 在链表中的第 index 个节点之前添加值为 val  的节点。
     * 如果 index 等于链表的长度，则该节点将附加到链表的末尾。
     * 如果 index 大于链表长度，则不会插入节点。
     * 如果index小于0，则在头部插入节点。
     *
     * @param index 节点下标
     * @param val   整数
     */
    void addAtIndex(int index, int val) {
        if (index > size) return;
        if (index < 0) index = 0;
        Node p = head;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        Node node = new Node(val, p.next);
        p.next = node;
        size++;
    }

    /**
     * 如果索引 index 有效，则删除链表中的第 index 个节点。
     *
     * @param index 节点索引
     */
    void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        Node pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = pre.next.next;
        size--;
    }

    @Override
    public String toString() {
        String s = "{";
        Node p = head.next;
        while (p != null) {
            s += p.val + " ";
            p = p.next;
        }
        s += "}";
        return s;
    }
}
