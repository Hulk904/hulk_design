package algorithms.other.dfs;

import algorithms.TreeNode;

/**
 * Created by yangyuan on 2021/11/13.
 * 993. 二叉树的堂兄弟节点
 *
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。

 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。

 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。

 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。

 */
public class IsCousins {
    public boolean isCousins(TreeNode root, int x, int y) {
        //a 记录x信息，b记录y信息
        int [] a = dfs(root, x, -1, 0);
        int[] b = dfs(root, y, -1, 0);
        return a[0] != b[0] && a[1] == b[1];
    }
    private int[] dfs(TreeNode root, int x, int v/*父节点值*/, int depth/*父节点层 */){
        if (root == null) return new int[]{0, 0};
        if (root.val == x) return new int[]{v, depth};
        int[] l = dfs(root.left, x, root.val, depth + 1);
        int[] r = dfs(root.right, x , root.val, depth + 1);
        return new int[]{l[0] + r[0], l[1] + r[1]};//两边必定有个是[0, 0]
    }
}
