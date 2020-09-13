package algorithms.other;

import algorithms.Node;

/**
 * Created by yangyuan on 2020/7/19.
 * 116. 填充每个节点的下一个右侧节点指针
 *
 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。

 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。

 初始状态下，所有 next 指针都被设置为 NULL。

 */
public class Connect {

    public Node connect(Node root) {
        if (root == null) return root;
        Node source = root;
        //从上往下。 在处理当前层的时候上层 next已初始化好
        while (root.left != null){
            for (Node p = root; p != null; p = p.next){
                // 左儿子的next等于 右儿子
                // 右儿子的next 等于 父的next
                p.left.next = p.right;
                if (p.next != null){
                    p.right.next = p.next.left;
                }
            }
            root = root.left;
        }
        return source;
    }
}
