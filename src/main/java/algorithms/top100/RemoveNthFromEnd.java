package algorithms.top100;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点
 * 注意长度为1的特殊处理
 *
 * Created by yangyuan on 2019/12/28.
 */
public class RemoveNthFromEnd {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3,null);
//        ListNode node2 = new ListNode(5, node1);
//        ListNode node3 = new ListNode(4, node2);
//        ListNode node4 = new ListNode(6, node3);
        removeNthFromEnd(node1, 1);
    }

    /**
     * 引入dummy节点 避免极端情况比如只有一个节点
     * 找到目标节点的前一个节点
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for (int i = 0; i < n ;i++){
            if (first == null){
                return head;
            }
            first = first.next;
        }
        while (second.next != null){
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }


    /**
     * 直接找到的是目标节点，这样删除会比较麻烦 ，
     * 应该找到目标节点前一个节点就行。然后直接修改指针
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEndBad(ListNode head, int n){
        if (n <=0 ){
            return head;
        }
        if (n == 1){
            if (head.next == null){
                return null;
            }
            ListNode cur = head;
            while (cur.next!= null){
                if (cur.next.next == null){
                    cur.next=null;
                    return head;
                }
                cur = cur.next;
            }
        }
        ListNode before = head, later = head;
        for (int i = 0; i<n-1; i++){
            later = later.next;
            if (later == null){
                return head;
            }
        }
        while (later.next!=null){
            before = before.next;
            later = later.next;
        }
        while (before.next != null){
            before.val = before.next.val;
            if (before.next.next == null){
                before.next=null;
                return head;
            }
            before = before.next;
        }
        return head;
    }




}

class ListNode{
    int val;
    ListNode next;
    public ListNode (int value){
        this.val = value;
    }

    public ListNode (int value, ListNode next){
        this.val = value;
        this.next = next;
    }

    public int getValue() {
        return val;
    }

    public void setValue(int value) {
        this.val = value;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
