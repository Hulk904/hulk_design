package algorithms.other;

import algorithms.ListNode;
import com.alibaba.fastjson.JSON;

/**
 * Created by yangyuan on 2020/2/11.
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

  

 示例:

 给定 1->2->3->4, 你应该返回 2->1->4->3.

 */
public class SwapPairs {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        listNode1.next=listNode;
        ListNode listNode2 = new ListNode(3);
        listNode2.next = listNode1;
        ListNode listNode3 = new ListNode(4);
        listNode3.next = listNode2;
        System.out.println(JSON.toJSONString(swapPairs(listNode3)));

    }

    /**
     * 超过十行自己再写遍
     * @param head
     * @return
     */
    public static  ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode previous = head;
        ListNode cur = head.next;
        head = head.next;
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = previous;
            if (temp != null) {
                if (temp.next != null) {
                    previous.next = temp.next;
                }else {
                    previous.next = temp;
                }
            } else {
                previous.next = temp;
                break;
            }
            previous = temp;
            cur = previous.next;
        }
        return head;
    }
}
