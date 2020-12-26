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


    int max1 = 0;

    List<Integer> res2 = new ArrayList();

    public int[] findModeError(TreeNode root) {
        dfs(root, 0);
        int[] n = new int[res.size()];
        for (int i = 0; i < res.size(); i++){
            n[i] = res.get(i);
        }
        return n;
    }

    //这里的问题是  pre和cur 都不是想要的值。 得弄成成员变量
    Integer dfs(TreeNode root, int cur){
        if (root == null) return null;
        Integer pre = dfs(root.left, cur);
        if (pre != null && pre == root.val){
            cur++;
        } else {
            cur = 1;
        }
        if (cur > max1){
            res2 = new ArrayList();
            max1 = cur;
            res2.add(root.val);
        } else if (cur == max1){
            res2.add(root.val);
        }
        dfs(root.right, cur);
        return root.val;
    }

}
