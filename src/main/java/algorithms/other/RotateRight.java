package algorithms.other;

import algorithms.ListNode;

/**
 * Created by yangyuan on 2020/3/1.
 * 61. 旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 */
public class RotateRight {

    /**
     * 先计算连表长度， 然后把k取模。k大于连表长度没有意义
     * 然后找到关键点进行拼接
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null){
            return null;
        }
        int n = 0;
        ListNode  temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        k = k%n;
        ListNode first = head, second = head;
        while (k-- >= 0){
            first = first.next;
        }
        while (first.next != null){
            first = first.next;
            second = second.next;
        }
        first.next = head;
        head = second.next;
        second.next = null;
        return head;

    }


}
