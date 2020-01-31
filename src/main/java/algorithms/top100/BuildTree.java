package algorithms.top100;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangyuan on 2020/1/6.
 *
 根据一棵树的前序遍历与中序遍历构造二叉树。

 注意:
 你可以假设树中没有重复的元素。
 */
public class BuildTree {

    public static void main(String[] args) {
        BuildTree buildTree = new BuildTree();
        int[] preOrder = {3,9,20,15,7};
        int[] inOrder = {9,3,15,20,7};
        System.out.println(JSON.toJSONString(buildTree.buildTree(preOrder, inOrder)));
    }


    private int[] preOrder;

    private int[] inOrder;

    private int preIndex = 0;

    private Map<Integer, Integer> inOrderMap = new HashMap<>();

    /**
     * 递归实现
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preOrder = preorder;
        this.inOrder = inorder;
        for (int i = 0; i < inOrder.length; i++){
            inOrderMap.put(inOrder[i], i);
        }
        return treeNode(0, inorder.length);
    }

    /**
     * 还需要具体理解
     * @param left
     * @param right
     * @return
     */
    private TreeNode treeNode (Integer left, Integer right){
        if (left >= right){
            return null;
        }
        TreeNode treeNode = new TreeNode(preOrder[preIndex]);
        Integer index = inOrderMap.get(preOrder[preIndex]);
        preIndex++;//为啥？？  每个节点都有左右子树，都需要依次构造/
        treeNode.left = treeNode(left, index);
        treeNode.right = treeNode(index + 1, right);
        return treeNode;
    }


}
