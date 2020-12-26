package algorithms.other.btree;

import algorithms.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yangyuan on 2020/11/15.
 * 508. 出现次数最多的子树元素和
 *
 * 给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。

 你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。

 */
public class FindFrequentTreeSum {

    Map<Integer, Integer> map = new HashMap();

    List<Integer> ans = new ArrayList();

    int max = 0;//当前出现的最大次数


    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++){
            res[i] = ans.get(i);
        }
        return res;
    }

    int dfs(TreeNode root){
        if (root == null){
            return 0;
        }
        int sum = root.val + dfs(root.left) + dfs(root.right);
        int num = 1 + map.getOrDefault(sum, 0);
        map.put(sum, num);
        //如果等于当前最大数则添加元素，如果大于当前最大值，那么新建一个数组，然后在插入当前元素。
        if (num > max){
            max = num;
            ans = new ArrayList();
            ans.add(sum);
        } else if (num == max){
            ans.add(sum);
        }
        return sum;
    }
}
