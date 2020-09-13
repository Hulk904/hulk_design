package algorithms.top100;

/**
 * Created by yangyuan on 2020/1/7.
 * 141. 环形链表
 * 给定一个链表，判断链表中是否有环。

 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环

 */
public class HasCycle {

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(2);
        ListNode listNode = new ListNode(1);
        listNode.next = listNode1;
        System.out.println(hasCycle(listNode));

    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null){
            return false;
        }
        ListNode slow = head, fast = head.next.next;
        while (slow != null && fast != null){
            if (slow == fast){
                return true;
            }
            slow = slow.next;
            if (fast.next == null){
                return false;
            }
            fast = fast.next.next;
        }
        return false;
    }
}
