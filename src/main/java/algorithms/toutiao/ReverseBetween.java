package algorithms.toutiao;

import algorithms.ListNode;
import com.alibaba.fastjson.JSON;

/**
 * Created by yangyuan on 2020/2/18.
 * 92
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

 说明:
 1 ≤ m ≤ n ≤ 链表长度。

 示例:

 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 输出: 1->4->3->2->5->NULL
 */
public class ReverseBetween {

    public static void main(String[] args) {
        ListNode node = new ListNode(5);
        ListNode node1 = new ListNode(4);
        node1.next = node;
        ListNode node2 = new ListNode(3);
        node2.next = node1;
        ListNode node3 = new ListNode(2);
        node3.next = node2;
        ListNode node4 = new ListNode(1);
        node4.next = node3;
        System.out.println(JSON.toJSONString(reverseBetween2(node4, 2, 4)));

    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        int distance = n - m;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        for(int i = 0; i <= distance; i++){
            fast = fast.next;
        }
        for (int i = 0; i < m -1; i++){
            fast = fast.next;
            slow = slow.next;
        }
        if (fast == null){
            ListNode previous = null;
            ListNode cur = dummy;
            while (cur != null){
                ListNode temp = cur.next;
                cur.next = previous;
                previous = cur;
                cur = temp;
            }
            return previous;
        }
        ListNode cur = slow.next;
        slow.next = fast;
        ListNode previous = fast.next;
        while (previous != fast){
            ListNode temp = cur.next;
            cur.next = previous;
            previous = cur;
            cur = temp;
        }
        return dummy.next;
    }

    /**
     * 一种更加优雅的翻转实现
     * https://leetcode-cn.com/problems/reverse-linked-list-ii/comments/
     *
     * 实现思路 ：以1->2->3->4->5, m = 2, n=4 为例:

     定位到要反转部分的头节点 2，head = 2；前驱结点 1，pre = 1；
     当前节点的下一个节点3调整为前驱节点的下一个节点 1->3->2->4->5,
     当前结点仍为2， 前驱结点依然是1，重复上一步操作。。。
     1->4->3->2->5.
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static ListNode reverseBetween2(ListNode head, int m, int n) {
        if (head == null){
           return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;//pre 为要翻转节点的前驱
        for (int i = 1; i < m; i++){
            pre = pre.next;
        }
        ListNode cur = pre.next;
        //把cur的next 插到pre的后面,  cur指向不变，所以不能在for循环里定义 , pre 的指向同样没有变
        for (int i = m; i < n; i++){
            ListNode next = cur.next;
            cur.next = next.next;
            //cur;//这里不能赋值为cur，第一次可能准确，但是后续的翻转就会有问题了。。
            //cur的指向一直未变
            next.next = pre.next;
            pre.next = next;
        }
        return dummy.next;
    }
}
