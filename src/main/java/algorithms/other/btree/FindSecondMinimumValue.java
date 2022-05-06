package algorithms.other.btree;

import algorithms.TreeNode;

import javax.lang.model.type.IntersectionType;

/**
 * Created by yangyuan on 2021/3/6.
 * 671. 二叉树中第二小的节点

 *
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。

 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。

 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。

 */
public class FindSecondMinimumValue {

    long d1 = Long.MAX_VALUE; //最大数
    long d2 = Long.MAX_VALUE; //第二大数
    //遍历树，然后找出第二小
    public int findSecondMinimumValue(TreeNode root) {
        dfs(root);
        if (d2 == Long.MAX_VALUE) return  -1;
        return (int)d2;
    }
    void dfs(TreeNode root){
        if (root == null) return;
        int x = root.val;
        if (x < d1) {d2 = d1; d1= x;}
        else if (x > d1 && x < d2) d2 = x;
        dfs(root.left);
        dfs(root.right);
    }
}
