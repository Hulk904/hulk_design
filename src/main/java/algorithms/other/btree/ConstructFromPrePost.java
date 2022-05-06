package algorithms.other.btree;

import algorithms.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangyuan on 2021/6/1.
 * 889. 根据前序和后序遍历构造二叉树
 * 返回与给定的前序和后序遍历匹配的任何二叉树。
 pre 和 post 遍历中的值是不同的正整数。
 */
public class ConstructFromPrePost {


    /**
     * 左右子树都存在时是唯一的，当左右子树有个为null 则不唯一
     * 这里当作左子树处理
     */
    Map<Integer, Integer> pos = new HashMap();
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int n = pre.length;
        for (int i = 0; i < n; i++) pos.put(post[i], i);
        return buildTree(pre, post, 0, n - 1, 0, n - 1);
    }
    TreeNode buildTree(int[] pre, int[] post, int a, int b, int x, int y){
        if (a > b) return null;
        TreeNode root = new TreeNode(pre[a]);
        if (a == b) return root;
        int k = pos.get(pre[a + 1]);
        root.left = buildTree(pre, post, a + 1, a + 1 + k - x, x , k);
        root.right = buildTree(pre, post, a + 1 + k - x + 1, b, k + 1, y - 1);
        return root;
    }
}
