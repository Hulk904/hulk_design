package algorithms.other;

import algorithms.TreeNode;

/**
 * Created by yangyuan on 2020/2/12.
 * 235. 二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]

 */
public class LowestCommonAncestor {

    public static void main(String[] args) {

    }

    /**
     * 迭代实现
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null){
            if (root.val > p.val && root.val > q.val){
                root = root.left;
                continue;
            }
            if (root.val < p.val && root.val < q.val){
                root = root.right;
                continue;
            }
            return root;
        }
        return root;
    }

    /**
     * 递归实现， 当pq都小于root时说明在左子树，当pq都大于root时说明在右子树
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestorRecurse(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val){
            return lowestCommonAncestorRecurse(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val){
            return lowestCommonAncestorRecurse(root.right, p, q);
        }
        return root;
    }
}
