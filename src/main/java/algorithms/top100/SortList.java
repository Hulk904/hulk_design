package algorithms.top100;

import com.alibaba.fastjson.JSON;

/**
 * Created by yangyuan on 2020/1/26.
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。

 示例 1:

 输入: 4->2->1->3
 输出: 1->2->3->4
 */
public class SortList {

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode node1= new ListNode(2);
        head.next = node1;
        ListNode node2 = new ListNode(1);
        node1.next = node2;
        ListNode node3= new ListNode(3);
        node2.next = node3;
        System.out.println(JSON.toJSONString(sortList(head)));
    }


    /**
     * 找到中间分割点，把连表分为两个  然后归并排序
     * 与数组不一样的，连表不需要辅助空间
     * @param head
     * @return
     */
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode fast = head.next, slow = head;// 如果这里初始化fast=head那么 递归将会死循环 大小为2的不能分为 1 和1 的连表
        while (fast != null && fast.next != null){//这里只用判断fast就行了
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode p2 = sortList(head);
        ListNode p1 = sortList(temp);
//        sortList(head);
//        sortList(temp);
        ListNode result = new ListNode(0);
        ListNode cur = result;
        while (p1 != null && p2 != null){
            if (p1.val > p2.val){
                cur.next = p2;
                p2 = p2.next;
            } else {
                cur.next = p1;
                p1 = p1.next;
            }
            cur = cur.next;
        }
        cur.next = p1 == null ? p2 : p1;
        return result.next;
    }
}
