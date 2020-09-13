package algorithms.other.list;

import algorithms.ListNode;

/**
 * Created by yangyuan on 2020/4/19.
 * 203. 移除链表元素
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 输入: 1->2->6->3->4->5->6, val = 6
 输出: 1->2->3->4->5
 这题跟 面试题18. 删除链表的节点 （DeleteNode）
 不一样的地方是它可能包含多个节点，并且这些节点可能连着。这是需要注意的地方
 */
public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur != null && cur.next != null){
            while (cur.next != null && cur.next.val == val){//删净后再改变指向
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
