package algorithms.top100;

/**
 * Created by yangyuan on 2020/1/7.
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
