package algorithms.other;
import algorithms.Node;

/**
 * Created by yangyuan on 2020/7/19.
 * 117. 填充每个节点的下一个右侧节点指针 II
 * 给定一个二叉树 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。
 * 如果找不到下一个右侧节点，则将 next 指针设置为 NULL。

 你只能使用常量级额外空间。
 */
public class Connect2 {

    /**
     * 使用两个 指针 把下一层串起来
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) return root;
        Node cur = root;
        while (cur != null){
            Node head = new Node(-1);
            Node tail = head;
            for (Node p = cur; p != null; p = p.next){
                if (p.left != null) tail = tail.next = p.left;
                if (p.right != null) tail = tail.next = p.right;
            }
            cur = head.next;
        }
        return root;
    }
}
