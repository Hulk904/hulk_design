package algorithms.other.list;

import algorithms.ListNode;

/**
 * Created by yangyuan on 2020/8/1.
 *
 * 147. 对链表进行插入排序
 */
public class InsertionSortList {

    public static void main(String[] args) {
        InsertionSortList in = new InsertionSortList();
        ListNode t = new ListNode(6);
        ListNode t2 = new ListNode(5);
        t.next = t2;
        ListNode t3 = new ListNode(3);
        t2.next = t3;
        ListNode t4 = new ListNode(7);
        t3.next = t4;
        in.insertionSortList(t);
        System.out.println(t.val);
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        for (ListNode p = head; p != null; ){
            ListNode cur = dummy, next = p.next;
            while (cur.next != null && cur.next.val <= p.val) cur = cur.next;
            p.next = cur.next;
            cur.next = p;
            p = next;// 这里的p = next ,不能写在 for 的最后 即 p = p.next.因为 p.next 的值已经变了
        }
        return dummy.next;
    }
}
