package algorithms.other.btree;

import algorithms.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangyuan on 2021/11/21.
 * 1008. 前序遍历构造二叉搜索树
 * 返回与给定前序遍历 preorder 相匹配的二叉搜索树（binary search tree）的根结点。

 (回想一下，二叉搜索树是二叉树的一种，其每个节点都满足以下规则，对于 node.left 的任何后代，值总 < node.val，而 node.right 的任何后代，值总 > node.val。此外，前序遍历首先显示节点 node 的值，然后遍历 node.left，接着遍历 node.right。）

 题目保证，对于给定的测试用例，总能找到满足要求的二叉搜索树。

 */
public class BstFromPreorder {
    int [] a, b;//a 前序， b中序
    Map<Integer, Integer> map = new HashMap();//记录中续遍历每个点的位置
    public TreeNode bstFromPreorder(int[] preorder) {
        a = preorder;
        b = Arrays.copyOf(preorder, preorder.length);
        Arrays.sort(b);
        for (int i = 0; i < preorder.length; i++) map.put(b[i], i);
        return build(0, preorder.length - 1, 0, preorder.length - 1);
    }
    TreeNode build(int x, int y, int l, int r){//x,y前序遍历的起始坐标  l,r 中序遍历的起始坐标
        if (x > y) return null;
        TreeNode root = new TreeNode(a[x]);
        int k = map.get(root.val);//中续中的位置
        root.left = build(x + 1, k - l + x/* 长度与中序遍历一样计算出来的*/, l , k - 1);
        root.right = build(k - l + x + 1, y, k + 1, r);
        return root;
    }
}
