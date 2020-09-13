package algorithms.other.btree;

import algorithms.TreeNode;
import algorithms.top100.TreeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yangyuan on 2020/2/29.
 * 173. 二叉搜索树迭代器
 * 不满足 o（h）的空间复杂度
 */
public class BSTIteratorError {

    public static void main(String[] args) {
        TreeNode treeNode = TreeUtil.buildTree(new Integer[]{2,1,3});
        BSTIteratorError obj = new BSTIteratorError(treeNode);
        int param_1 = obj.next();
        boolean param_2 = obj.hasNext();
    }

    List<Integer> list = new ArrayList<>();

    int curIndex ;

    public BSTIteratorError(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        if (cur == null){
            return ;
        }
        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        curIndex = 0;
    }

    /** @return the next smallest number */
    public int next() {
       if (curIndex < list.size()) {
           return list.get(curIndex++);
       }
        throw new IndexOutOfBoundsException("error");
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return curIndex < list.size();
    }
}
