package algorithms.other;


/**
 * Created by yangyuan on 2020/7/26.
 * 138. 复制带随机指针的链表
 *
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。

 要求返回这个链表的 深拷贝。
 */
public class CopyRandomList {

    public Node copyRandomList(Node head) {
        //复制节点元素
        for (Node p = head; p != null; p = p.next.next){
            Node q = new Node(p.val);
            q.next = p.next;
            p.next = q;
        }
        //复制random 指针
        for (Node p = head; p != null; p =p.next.next){
            if (p.random != null){
                p.next.random = p.random.next;
            }
        }
        //拆分连表
        Node dummy = new Node(-1);
        Node cur = dummy;
        for (Node p = head; p != null; p = p.next){
            Node q = p.next;
            cur = cur.next = q;
            p.next = q.next;
        }
        return dummy.next;
    }



    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
