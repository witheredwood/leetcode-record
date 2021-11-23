# 【Leetcode之哈希表】0705 设计哈希表

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/distribute-candies

实现语言：Java



##  题目

给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。

**示例**

```
输入: candies = [1,1,2,2,3,3]
输出: 3
解析: 一共有三种种类的糖果，每一种都有两个。
     最优分配方案：妹妹获得[1,2,3],弟弟也获得[1,2,3]。这样使妹妹获得糖果的种类数最多。

输入: candies = [1,1,2,3]
输出: 2
解析: 妹妹获得糖果[2,3],弟弟获得糖果[1,1]，妹妹有两种不同的糖果，弟弟只有一种。这样使得妹妹可以获得的糖果种类数最多。
```

- **注意:**
  1. 数组的长度为[2, 10,000]，并且确定为偶数。
  2. 数组中数字的大小在范围[-100,000, 100,000]内。

## 方法

使用链表实现哈希表，默认构造一个带有头结点的链表。

**代码实现**

```java
class HashNode {
    int val;
    HashNode next;
    public HashNode() {}
    public HashNode(int val) {
        this.val = val;
        this.next = null;
    }
    public HashNode(int val, HashNode next) {
        this.val = val;
        this.next = next;
    }

}
class MyHashSet {
    HashNode head;
    /** Initialize your data structure here. */
    public MyHashSet() {
        // the head node
        head = new HashNode();
    }
    
    public void add(int key) {       
        HashNode pre = this.head;
        while (pre.next!=null){
            if (pre.next.val == key) return;
            pre = pre.next;
        }  
        HashNode node = new HashNode(key);
        pre.next = node;
    }
    
    public void remove(int key) {
        for (HashNode pre=head; pre.next!=null; pre=pre.next) {
            if (pre.next.val == key) {
                pre.next = pre.next.next;
                return;
            }
        }        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        for (HashNode p=head.next; p!=null; p=p.next) {
            if (p.val == key) return true;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
```

执行用时：143 ms

内存消耗：44.2 MB

