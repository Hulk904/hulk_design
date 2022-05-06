package algorithms.other.list;

/**
 * Created by yangyuan on 2021/3/14.
 *
 * 707. 设计链表
 *
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，
 * next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。
 * 假设链表中的所有节点都是 0-index 的。
 在链表类中实现这些功能：
 get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，
 则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 */
public class MyLinkedList {
    private Node head;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = null;
    }
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0) return -1;
        Node p = head;
        for (int i = 0; i < index && p != null; i++){
            p = p.next;
        }
        if (p == null) return -1;
        return p.val;
    }
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node cur = new Node(val);
        cur.next = head;
        head = cur;
    }
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (head == null){
            head = new Node(val);
        } else {
            Node cur = head;
            while (cur.next != null) cur = cur.next;
            cur.next = new Node(val);
        }
    }
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index <= 0) addAtHead(val);
        else {
            int len = 0;
            for (Node p = head; p != null; p = p.next) len++;
            if (index == len) addAtTail(val);
            else {
                Node p = head;
                for (int i = 0; i < index - 1; i ++) p = p.next;
                Node cur = new Node(val);
                cur.next = p.next;
                p.next = cur;
            }
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        int len = 0;
        for (Node p = head; p != null; p = p.next){
            len++;
        }
        if (index >= 0 && index < len){
            if (index == 0) head = head.next;
            else {
                Node p = head;
                for (int i = 0; i < index - 1; i++) p = p.next;
                p.next = p.next.next;
            }
        }
    }

    class Node{
        int val;
        Node next;

        public Node(int val){
            this.val = val;
        }
    }
}













