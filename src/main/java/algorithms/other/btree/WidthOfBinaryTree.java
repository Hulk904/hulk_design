package algorithms.other.btree;

import algorithms.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yangyuan on 2021/2/28.
 *
 * 662. 二叉树最大宽度
 *
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。

 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。

 */
public class WidthOfBinaryTree {

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<Pair> q = new LinkedList();
        q.add(new Pair(root, 1));
        int res = 1;
        while (q.size() > 0){
            int size = q.size();
            int l = q.peek().index;
            int r = 0;
            for (int i = 0; i < size; i++){
                Pair pair = q.poll();
                TreeNode v = pair.node;
                int p = pair.index - l + 1;//相对位置   每层 元素下标都是从1开始
                r = pair.index;
                if (v.left != null) q.add(new Pair(v.left, p *2));
                if (v.right != null) q.add(new Pair(v.right, p* 2 + 1));
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    class Pair{
        TreeNode node;
        Integer index;
        public Pair(TreeNode node, Integer index){
            this.node = node;
            this.index = index;
        }
    }
}
