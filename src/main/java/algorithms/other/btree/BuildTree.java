package algorithms.other.btree;

import algorithms.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangyuan on 2020/7/18.
 * 106. 从中序与后序遍历序列构造二叉树
 */
public class BuildTree {

    Map<Integer, Integer> map = new HashMap<>();

    int[] inorder;

    int[] postorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        for (int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return build(0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode build(int il, int ir, int pl, int pr){
        if (ir < il || pr < pl) return null;
        TreeNode node = new TreeNode(postorder[pr]);
        int k = map.get(postorder[pr]);
        node.left = build(il, k - 1, pl, pl + k - 1 - il);// pl + k - 1 - il 通过距离计算
        node.right = build(k + 1, ir, pl + k - 1 -il + 1, pr - 1);
        return node;
    }

}
