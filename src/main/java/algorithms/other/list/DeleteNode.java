package algorithms.other.list;

import algorithms.ListNode;

/**
 * Created by yangyuan on 2020/4/19.
 * 面试题18. 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。

 返回删除后的链表的头节点。

 注意：此题对比原题有改动
 */
public class DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur != null && cur.next != null){
            if (cur.next.val == val){
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
