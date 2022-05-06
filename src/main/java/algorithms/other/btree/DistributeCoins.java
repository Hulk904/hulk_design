package algorithms.other.btree;

import algorithms.TreeNode;

/**
 * Created by yangyuan on 2021/7/11.
 * 979. 在二叉树中分配硬币
 *
 * 给定一个有 N 个结点的二叉树的根结点 root，树中的每个结点上都对应有 node.val 枚硬币，并且总共有 N 枚硬币。

 在一次移动中，我们可以选择两个相邻的结点，然后将一枚硬币从其中一个结点移动到另一个结点。
 、(移动可以是从父结点到子结点，或者从子结点移动到父结点。)。

 返回使每个结点上只有一枚硬币所需的移动次数。

 */
public class DistributeCoins {
    public int distributeCoins(TreeNode root) {
        //考虑每条边对答案的贡献
        //遍历求每个子树的金币数和节点数，  差值的绝对值之和 就是最后的答案
        return dfs(root)[2];
    }
    //0 节点数
    //1 金币数
    //操作次数
    int[] dfs(TreeNode root){
        if (root == null) return new int[]{0, 0, 0};
        int[] l = dfs(root.left), r = dfs(root.right);
        int x = l[0] + r[0] + 1, y = l[1] + r[1] + root.val;
        return new int[]{x, y, Math.abs(x - y) + l[2] + r[2]};
    }
}
