package algorithms.other;

import algorithms.ListNode;

/**
 * Created by yangyuan on 2020/3/19.
 * 25. K 个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 k 是一个正整数，它的值小于或等于链表的长度。
 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

 * https://github.com/labuladong/fucking-algorithm/blob/master/%E9%AB%98%E9%A2%91%E9%9D%A2%E8%AF%95%E7%B3%BB%E5%88%97/k%E4%B8%AA%E4%B8%80%E7%BB%84%E5%8F%8D%E8%BD%AC%E9%93%BE%E8%A1%A8.md
 *
 */
public class ReverseKGroup {

    /**
     * k个一组 递归实现
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode a = head, b = head;
        int temp = k;
        while (temp-- > 0){//这里不能写 k-- 啊，不然后面递归时 k就是0了。
            if (b == null) return head;
            b = b.next;
        }
        ListNode newNode = reverse(a, b);
        a.next = reverseKGroup(b, k);
        return newNode;
    }

    /**
     * 翻转 两个节点之间的数据。 思想来源于翻转链表
     * @param head
     * @param tail
     * @return
     */
    public ListNode reverse(ListNode head, ListNode tail){
        ListNode pre = null, cur = head;
        while (cur != tail){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        for (ListNode pre = dummy;;){
            ListNode q = pre;
            for (int i = 0; i < k && q != null; i++) q = q.next;
            if (q == null) break;
            ListNode a = pre.next, b = a.next;
            //翻转内部的k-1个节点
            for (int i = 0; i < k - 1; i++){
                ListNode next = b.next;
                b.next = a;
                a = b;
                b = next;
            }
            ListNode c = pre.next;
            pre.next = a;
            c.next = b;
            pre = c;
        }
        return dummy.next;
    }
}
