package algorithms.other;

import algorithms.ListNode;

/**
 * Created by yangyuan on 2020/4/14.
 * 328. 奇偶链表
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，
 * 这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。

 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。

 */
public class OddEvenList {

    /**
     * 自己写的
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        ListNode p = new ListNode(-1);
        ListNode pi = p;
        ListNode n = new ListNode(-1);
        ListNode ni = n;
        int index = 1;
        while (head != null){
            if (index%2 == 1){
                pi.next = head;
                pi = pi.next;
            } else {
                ni.next = head;
                ni = ni.next;
            }
            head = head.next;
            index++;
        }
        ni.next = null;
        pi.next = n.next;
        return p.next;
    }

    /**
     *  leetcode官方答案
     * @param head
     * @return
     */
    public ListNode oddEvenList2(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        //一次处理两个节点，不用像上面还需要 用index标识
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;//最后一次even 的尾节点会指向 null 的。
        }
        odd.next = evenHead;
        return head;
    }

}
