package algorithms.other.dfs;

import algorithms.TreeNode;

/**
 * Created by yangyuan on 2021/7/10.
 * 968. 监控二叉树
 给定一个二叉树，我们在树的节点上安装摄像头。

 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。

 计算监控树的所有节点所需的最小摄像头数量。

 打家劫舍 类似
 */
public class MinCameraCover {

    public int minCameraCover(TreeNode root) {
        int [] d = dfs(root);
        return Math.min(d[1], d[2]);
    }
    //
    int[] dfs(TreeNode root){
        if (root == null) return new int[]{0, 0, 10000000};
        int[] l = dfs(root.left), r = dfs(root.right);
        return new int[]{
                Math.min(l[1], l[2]) + Math.min(r[1], r[2]),//0 记录 当前节点被父节点看 ： 当前节点没有摄像头
                Math.min(l[2] + Math.min(r[1], r[2]), r[2] + Math.min(l[1], l[2])),// 1 记录 当前节点被子节点看
                Math.min(l[0], Math.min(l[1], l[2])) + Math.min(r[0], Math.min(r[1], r[2])) + 1// 2 当前节点被自己看
        };
    }
}
