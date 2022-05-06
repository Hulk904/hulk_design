package algorithms.other;

import algorithms.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yangyuan on 2021/6/14.
 * 919. 完全二叉树插入器
 *
 * 完全二叉树是每一层（除最后一层外）都是完全填充（即，节点数达到最大）的，并且所有的节点都尽可能地集中在左侧。

 设计一个用完全二叉树初始化的数据结构 CBTInserter，它支持以下几种操作：

 CBTInserter(TreeNode root) 使用头节点为 root 的给定树初始化该数据结构；
 CBTInserter.insert(int v)  向树中插入一个新节点，节点类型为 TreeNode，值为 v 。使树保持完全二叉树的状态，并返回插入的新节点的父节点的值；
 CBTInserter.get_root() 将返回树的头节点。

 */
public class CBTInserter {
    TreeNode root;
    List<TreeNode> h;

    public CBTInserter(TreeNode root) {
        h = new ArrayList();
        h.add(null);//父节点跟子节点 n  2n, 2n+1 的关系，需要下标从1 开始
        this.root = root;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(q.size() > 0){
            TreeNode t = q.poll();
            h.add(t);
            if (t.left != null) q.add(t.left);
            if (t.right != null) q.add(t.right);
        }
    }

    public int insert(int v) {
        TreeNode t = new TreeNode(v);
        h.add(t);
        int k = h.size() - 1;
        int p = k/2;
        if (p*2 == k) h.get(p).left = t;
        else h.get(p).right = t;
        return h.get(p).val;
    }

    public TreeNode get_root() {
        return root;
    }
}
