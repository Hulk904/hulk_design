package algorithms.other;

import algorithms.ListNode;

/**
 * Created by yangyuan on 2020/4/25.
 * 876. 链表的中间结点
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 *如果有两个中间结点，则返回第二个中间结点。
 */
public class MiddleNode {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 对比下上面的，自己写的确实有点累赘
     * 虽然都是细节，但是反应功底
     * @param head
     * @return
     */
    public ListNode middleNode2(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next == null) return slow;
        return slow.next;
    }
}
