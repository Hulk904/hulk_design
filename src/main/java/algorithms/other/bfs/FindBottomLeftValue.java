package algorithms.other.bfs;

import algorithms.TreeNode;
import apple.laf.JRSUIUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yangyuan on 2020/11/15.
 */
public class FindBottomLeftValue {

    public int findBottomLeftValue(TreeNode root) {
        int res = root.val;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while (!q.isEmpty()){
            res = q.peek().val;
            int size = q.size();
            while (size-- > 0){
                TreeNode cur = q.poll();
                if (cur.left != null){
                    q.add(cur.left);
                }
                if (cur.right != null){
                    q.add(cur.right);
                }
            }
        }
        return res;
    }

    /**
     * 递归实现
     * 需要规定先遍历左节点，然后再遍历右节点
     *
     * 为了确定层数，所以需要传递层数
     */

    int ans;
    int max = 0;

    public int findBottomLeftValue2(TreeNode root) {
        dfs(root, 1);
        return ans;
    }

    private void dfs(TreeNode root, int level){
        if (root == null) return ;
        if (level > max){//表示新的层
            max = level;
            ans = root.val;
        }
        dfs(root.left, level  + 1);
        dfs(root.right, level + 1);
    }
}
