package algorithms.toutiao;

import algorithms.TreeNode;
import algorithms.top100.TreeUtil;

/**
 * Created by yangyuan on 2020/2/17.
 */
public class HasPathSum {

    private int totalSum;

    private boolean result = false;

    public static void main(String[] args) {
        TreeNode treeNode = TreeUtil.buildTree(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,null,null,1});//
        HasPathSum hasPathSum = new HasPathSum();
        hasPathSum.hasPathSum(treeNode, 22);
        System.out.println(hasPathSum.result);

    }


    public  boolean hasPathSumOfficial(TreeNode root, int sum){
        if (root == null){
            return false;
        }
        if (root.left == null && root.right == null){//叶子节点
            return sum - root.val == 0;
        }
        return hasPathSumOfficial(root.left, sum - root.val) || hasPathSumOfficial(root.right, sum - root.val);
    }

    /**
     * 自己写的递归，还是很冗长的
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null){
            return false;
        }
        totalSum = sum;
        sonSum(root, "", 0);
        return result;
    }


    private   void sonSum(TreeNode root, String path, int sum){
        if (root != null && root.left == null && root.right == null){
            System.out.println(path + "=>" + root.val + "  total="+ (sum + root.val));
            if (sum + root.val == totalSum){
                result = true;
            }
            return ;
        }
        if (root.left != null) {
            sonSum(root.left, path + "=>" + root.val, sum + root.val);
        }
        if (root.right != null) {
            sonSum(root.right, path + "=>" + root.val, sum + root.val);
        }
    }
}
