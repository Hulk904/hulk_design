package algorithms.top100;


import algorithms.TreeNode;

/**
 * Created by yangyuan on 2020/1/16.
 * 543. 二叉树的直径
 *
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。

 示例 :
 给定二叉树

 1
 / \
 2   3
 / \
 4   5
 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。

 注意：两结点之间的路径长度是以它们之间边的数目表示。
 跟 124 maxSum 类似

 */
public class DiameterOfBinaryTree {

    private int radius = 1;

    public static void main(String[] args) {

    }

    public int diameterOfBinaryTree(TreeNode root){
        if (root == null) return 0;
        doDiameterOfBinaryTree(root);
        return radius;
    }

    /**
     * 返回的是左或右子树最长的那个(距离)
     * 而最终的结果是通过成员变量 得到
     * @param root
     * @return
     */
    public int doDiameterOfBinaryTree(TreeNode root) {
        if (root == null){
            return 0;
        }
        int leftDepth = doDiameterOfBinaryTree(root.left);
        int rightDepth = doDiameterOfBinaryTree(root.right);
        radius = Math.max(leftDepth + rightDepth, radius) ;//不需要加1 ，不是计算节点数呢
        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * 自己错误的递归写法
     * @param root
     * @return
     */
    private int radiusError(TreeNode root){
        if (root == null) return 0;
        int left = radiusError(root.left) ;
        int right = radiusError(root.right) ;
        radius = Math.max(radius, left + right);
        return left + right;
    }

}
