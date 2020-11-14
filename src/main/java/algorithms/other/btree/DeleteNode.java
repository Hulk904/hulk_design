package algorithms.other.btree;

import algorithms.TreeNode;

/**
 * Created by yangyuan on 2020/10/31.
 * 450. 删除二叉搜索树中的节点
 *
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。

 一般来说，删除节点可分为两个步骤：

 首先找到需要删除的节点；
 如果找到了，删除它。

 */
public class DeleteNode {

    /**
     *   1  叶节点  直接删除
     *   2  只有一个子节点  直接将子树提上来
     *   3  有两个子节点  找到后继节点， 将值覆盖删除的点，删除后继 （后继怎么求？ 右子树不断往左走）
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (key > root.val) root.right = deleteNode(root.right, key);
        else if (key < root.val) root.left = deleteNode(root.left, key);
        else {
            if (root.left == null && root.right == null) root = null;
            else if (root.right != null){//有右儿子
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            } else {//有左儿子
                root.val = precessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }

    //后继
    public int successor (TreeNode root){
        root = root.right;
        while (root.left != null) root = root.left;
        return root.val;
    }

    //前驱
    public int precessor(TreeNode root){
        root = root.left;
        while (root.right != null) root = root.right;
        return root.val;
    }

    /**
     * 感觉不是很好理解啊
     */
    public TreeNode deleteNode2( TreeNode root, int key) {
        if (root == null) return null;
        if (key < root.val){
            root.left = deleteNode2(root.left, key);
        } else if (key > root.val){
            root.right = deleteNode2(root.right, key);
        } else {
            if (root.left == null){
                return root.right;
            }
            if (root.right == null){
                return root.left;
            }
            TreeNode node = root.right;
            while (node.left != null){
                node = node.left;
            }
            //将root的左子树放到root的右子树的最下面的左叶子节点的左子树上
            //这样就删除 当前节点啦？
            //返回的是root.right  上面的赋值语句相当于删除了节点
            //  删除 节点 2
            //       2
            //      /  \
            //     1    4
            //         /
            //        3
            // 会变为
            //       4
            //      /
            //     3
            //    /
            //   1
            //返回的是 4 节点
            //而第一种方法 返回的结构是

            //      3
            //     / \
            //    1   4
            //然后返回 3 节点
            node.left = root.left;
            return root.right;
        }
        return root;
    }

}
