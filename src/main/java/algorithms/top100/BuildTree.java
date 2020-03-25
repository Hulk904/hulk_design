package algorithms.top100;

import algorithms.TreeNode;
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
     * preorder 中的第一个元素一定是树的根，这个根又将 inorder 序列分成了左右两棵子树。
     * 现在我们只需要将先序遍历的数组中删除根元素，然后重复上面的过程处理左右两棵子树
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
        treeNode.left = treeNode(left, index);//left -> index 左子树范围
        treeNode.right = treeNode(index + 1, right); // index + 1  -> right 右子树范围
        return treeNode;
    }


}
