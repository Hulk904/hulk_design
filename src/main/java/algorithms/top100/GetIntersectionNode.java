package algorithms.top100;

/**
 * Created by yangyuan on 2020/1/9.
 * 160. 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 *
 */
public class GetIntersectionNode {

    public static void main(String[] args) {
        ListNode a = new ListNode(3);
        ListNode b1 = new ListNode(4);
        ListNode b = new ListNode(2);
        b.next = b1;
        method2(a,b);

    }

    public static  ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        int lengthA = 0;
        int lengthB = 0;
        ListNode tempa = headA, tempb = headB;
        while (tempa != null){
            lengthA++;
            tempa = tempa.next;
        }
        while (tempb != null) {
            lengthB++;
            tempb = tempb.next;
        }
        for (int i = Math.abs(lengthA - lengthB); i >0 ; i --){
            if (lengthA > lengthB){
                headA = headA.next;
            } else {
                headB = headB.next;
            }
        }
        while (headA != null || headB != null){
            if (headA == headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }


    /**
     * 另一种实现： 到了对尾 换到另一个连表上， 直到他们相等 ps：一定会相等
     * 如果有相交就会返回相交的点，如果没有则会返回null
     * 这个的好处是不需要 计算出两个连表的长度的
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode method2 (ListNode headA, ListNode headB){
        if (headA == null || headB == null) return null;
        //这里得借助中间中间变量，
        /*
         while (headA != headB) {
            headA = headA == null ? headB : headA.next;
            headB = headB == null ? headA : headB.next;
            这样是不行的。
        }
         */
        ListNode pA = headA, pB = headB;
        //对于两个连表本身就没有交点 这也是成立的
        //这时候 pA = null， pB = null 了
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    public ListNode getIntersectionNodeError(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode p = headA;
        ListNode q = headB;
        while (p != q){
             if (p == null){
                 p = headB;
             }
             if (q == null){
                 q = headA;
             }
             p = p.next;
             q = q.next;
        }
        return p;
    }
}
