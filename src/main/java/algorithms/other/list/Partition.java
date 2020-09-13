package algorithms.other.list;

import algorithms.ListNode;

/**
 * Created by yangyuan on 2020/4/19.
 * 86. 分隔链表
 *
 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。

 你应当保留两个分区中每个节点的初始相对位置。
 */
public class Partition {

    /**
     * 题目并不难，但是刚开始自己的思路卡死在就在当前链表上操作，最后把自己给绕晕了
     * 使用两个链表单独处理，思路就比较清晰了。。最后在连在一块
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1);
        ListNode before = dummy1;
        ListNode dummy2 = new ListNode(-1);
        ListNode after = dummy2;
        while (head != null){
            if (head.val < x){
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        before.next = dummy2.next;
        after.next = null;
        return dummy1.next;
    }
}
