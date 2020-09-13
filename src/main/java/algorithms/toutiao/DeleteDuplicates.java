package algorithms.toutiao;

import algorithms.ListNode;

/**
 * Created by yangyuan on 2020/4/11.
 * 82. 删除排序链表中的重复元素 II
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 */
public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;//指向不是重复元素的点
        while (cur.next != null && cur.next.next != null){
            if (cur.next.val == cur.next.next.val){//存在重复元素
                ListNode temp = cur.next;
                while (temp.next != null && temp.val == temp.next.val){
                    temp = temp.next;
                }
                //temp最终指向重复元素的最后一个元素
                cur.next = temp.next;//注意这里的赋值。
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while(cur.next != null && cur.next.next != null) {
            ListNode temp = cur.next.next;
            while (temp != null && temp.val == cur.next.val) temp = temp.next;
            if (cur.next.next == temp) cur = cur.next;
            else cur.next = temp;
        }
        return dummy.next;
    }

}
