package algorithms.top100;

/**
 * Created by yangyuan on 2019/12/29.
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

 示例：

 输入：1->2->4, 1->3->4
 输出：1->1->2->3->4->4

 */
public class MergeTwoList {

    public static void main(String[] args) {
        ListNode2 t2 = new ListNode2(4);
        ListNode2 t1 = new ListNode2(2);
        t1.next = t2;
        ListNode2 l1 = new ListNode2(1);
        l1.next = t1;
        ListNode2 t3 = new ListNode2(4);
        ListNode2 t4 = new ListNode2(3);
        t4.next = t3;
        ListNode2 l2 = new ListNode2(1);
        l2.next = t4;
        ListNode2 result = mergeTwoLists(l1,l2);
        System.out.println(result);
    }


    private static ListNode2 mergeTwoLists(ListNode2 l1, ListNode2 l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode2 dummy = new ListNode2(0);
        ListNode2 n1 = l1;
        ListNode2 n2 = l2;
        ListNode2 curr = dummy;
        while (n1 != null || n2 != null) {
            if (n1 == null || (n2 != null && n1.val >= n2.val )) {//注意等值的处理 和n1不为null 但是n2为null 导致np问题
                curr.next = n2;
                n2 = n2.next;
                curr = curr.next;
                continue;
            }
            if (n2 == null || (n1 != null && n1.val <= n2.val)){
                curr.next = n1;
                n1 = n1.next;
                curr = curr.next;
            }
        }
        return dummy.next;
    }

}
class ListNode2 {
     int val;
     ListNode2 next;
     ListNode2(int x)
     { val = x;
     }
 }
