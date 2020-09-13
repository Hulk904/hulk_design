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
            //小剪枝  这种方式跟子集 有重复元素差不多。。
            // 1、i > index 表明剪枝的分支一定不是当前层的第 1 个分支
            // 2、input[i - 1] == input[i] 表明当前选出来的数等于当前层前一个分支选出来的数
            // 因为前一个分支的候选集合一定大于后一个分支的候选集合
            // 故后面出现的分支中一定包含了前面分支出现的结果，因此剪枝
            // “剪枝”的前提是排序，升序或者降序均可
            if (i > index && candidates[i] == candidates[i - 1]){
                continue;
            }
            path.push(candidates[i]);
            dfs(candidates, reside - candidates[i], i + 1, path);//注意是i+1 啊 。。
            path.pop();
        }
    }


}
