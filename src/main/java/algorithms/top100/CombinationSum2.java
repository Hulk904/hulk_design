package algorithms.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by yangyuan on 2020/3/4.
 * 40. 组合总和 II
 *
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

 candidates 中的每个数字在每个组合中只能使用一次。

 说明：

 所有数字（包括目标数）都是正整数。
 解集不能包含重复的组合。 

 */
public class CombinationSum2 {

    private List<List<Integer>> res ;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new Stack<>());
        return res;
    }

    private void dfs(int[] candidates, int reside, int index, Stack<Integer> path){
        if (reside == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < candidates.length; i++){
            // 大剪枝  只有排序的才能这么剪枝呢。。
            if (reside - candidates[i] < 0) break;
            //小剪枝  这种方式跟全排列，子集 有重复元素差不多。。
            if (i > index && candidates[i] == candidates[i - 1]){
                continue;
            }
            path.push(candidates[i]);
            dfs(candidates, reside - candidates[i], i + 1, path);//注意是i+1 啊 。。
            path.pop();
        }
    }


}
