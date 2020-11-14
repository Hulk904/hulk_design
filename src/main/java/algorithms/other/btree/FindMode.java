package algorithms.other.btree;

import algorithms.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyuan on 2020/11/14.
 * 501. 二叉搜索树中的众数
 *
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 */
public class FindMode {

    List<Integer> res = new ArrayList<>();

    int max = 0;//最大个数

    int cur = 0;//相同元素总数

    int last ; //上一个元素

    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] arr = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            arr[i] = res.get(i);
        }
        return arr;
    }

    private void dfs(TreeNode root){
        if (root == null) return;
        dfs(root.left);
        if (cur == 0 || root.val == last){
            last = root.val;
            cur++;
        } else {
            cur = 1;
            last = root.val;
        }
        if (cur > max){
            res = new ArrayList<>();
            max = cur;
            res.add(last);
        } else if (cur == max) {
            res.add(last);
        }
        dfs(root.right);
    }

}
