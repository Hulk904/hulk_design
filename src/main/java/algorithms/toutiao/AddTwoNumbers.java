package algorithms.toutiao;

import algorithms.ListNode;
import com.alibaba.fastjson.JSON;

import java.util.Stack;

/**
 * Created by yangyuan on 2020/2/9.
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        System.out.println(JSON.toJSONString(addTwoNumbers(l1, l2)));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (l1 != null){
            stack1.add(l1);
            l1 = l1.next;
        }
        while (l2 != null){
            stack2.add(l2);
            l2 = l2.next;
        }
        ListNode head = null;
        int extra = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()){
            int num = 0;
            if (!stack1.isEmpty()){
                num += stack1.pop().val;
            }
            if (!stack2.isEmpty()){
                num += stack2.pop().val;
            }
            num += extra;
            ListNode temp = new ListNode(num%10);
            extra = num/10;
            temp.next = head;
            head = temp;
        }
        if (extra  == 1){
            ListNode temp = new ListNode(1);
            temp.next = head;
            head = temp;
        }
        return head;
    }
}
