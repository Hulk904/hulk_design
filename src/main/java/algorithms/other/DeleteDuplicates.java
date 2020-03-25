package algorithms.other;

import algorithms.ListNode;

/**
 * Created by yangyuan on 2020/3/1.
 * 83. 删除排序链表中的重复元素
 *
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

 示例 1:

 输入: 1->1->2
 输出: 1->2

 思路很重要，不要急于写代码
 情况1：如果下个节点和当前节点相同，删除下一个节点
 情况2：如果下个节点和当前节点不同，则指针移到下个节点

 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode cur = head;
        while (cur.next != null){
            if (cur.val == cur.next.val){
                cur.next = cur.next.next;//cur 没必要后移，指向不变
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    /**
     * 思路还不清晰的情况下写的代码，冗长还不正确。。。。
     * @param head
     * @return
     */
    public ListNode deleteDuplicatesError(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null){
            while( fast != null && slow.val == fast.val) {
                fast = fast.next;
            }
            if (fast == null) break;
            slow.next = fast;
            slow = slow.next;
            fast = fast.next;
        }
        return head;
    }

}
