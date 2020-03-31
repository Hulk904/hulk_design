package algorithms.top100;

import com.alibaba.fastjson.JSON;

/**
 * Created by yangyuan on 2020/1/9.
 * 翻转连表
 */
public class ReverseList {

    public static void main(String[] args) {

        ListNode listNode = new ListNode(3);
        ListNode listNode1 = new ListNode(2);
        listNode1.next = listNode;
        ListNode listNode2 = new ListNode(1);
        listNode2.next = listNode1;
        System.out.println(JSON.toJSONString(listNode2));
        System.out.println(JSON.toJSONString(reverseList(listNode2)));

    }

    public static ListNode reverseListIterator(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode after = head, before = head.next;
        head.next = null;
        while (before != null){
            ListNode temp = before.next;//注意 别掉了
            before.next = after;
            after = before;
            before = temp;
        }
        return  after;
    }

    /**
     * 递归实现  不是很好理解呢。。。
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode temp = reverseList(head.next);
        //temp.next = head;
        head.next.next = head; //注意
        head.next = null;
        return temp;
    }


}
