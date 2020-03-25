package algorithms.top100;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yangyuan on 2020/1/10.
 * 连表是否存在环，如果有的话找出第一个点
 */
public class DetectCycle {

    public static void main(String[] args) {


    }


    /**
     * 这个实现比较差  更好的方式使用双指针。之前看过，但是第二次还是没有思路。
     * @param head
     * @return
     */
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        ListNode cur = head;
        Set<ListNode> listNodeSet = new HashSet<>();
        while (cur != null){
            if (listNodeSet.contains(cur)){
                return cur;
            }
            listNodeSet.add(cur);
            cur = cur.next;
        }
        return cur;
    }

    public static ListNode detectCycle2(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode fast = head, slow = head;
        while (fast != null){
            slow = slow.next;
            fast = fast.next;
            if (fast != null){
                fast = fast.next;
            } else {
                return null;
            }
            if (fast == slow){
                slow = head;
                while (fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}
