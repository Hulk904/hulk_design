package algorithms.top100;

/**
 * Created by yangyuan on 2020/1/12.
 *
 * 请判断一个链表是否为回文链表。

 示例 1:

 输入: 1->2
 输出: false
 示例 2:

 输入: 1->2->2->1
 输出: true


 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 既然要o(1)的空间复杂度，所以需要修改连表结构了
 注意处理场景：
 1-2-1
 1-2-2-1
 */
public class IsPalindrome {

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(0);
        listNode2.next = listNode1;
        ListNode listNode3 = new ListNode(1);
        listNode3.next = listNode2;
        System.out.println(isPalindrome(listNode3));
    }

    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode slow = head, fast = head;// fast=head.next.next  初始化如果写为这个，后面处理的时候会比较麻烦
        ListNode pre = null;
        while (fast != null && fast.next != null){
            fast = fast.next.next;//注意 放在前面，不然后面值可能变化
            ListNode temp = slow.next;//提前在这里保存好 slow.next. 而不是在最后写slow=temp.next (这个时候temp.next指向已经变了)
            slow.next = pre;
            pre = slow;
            slow = temp;
        }
        if (fast != null ){
            slow = slow.next;
        }
        while (slow != null){
            if (pre.val != slow.val){

                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }
}
