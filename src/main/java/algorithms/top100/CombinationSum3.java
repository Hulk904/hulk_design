package algorithms.top100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yangyuan on 2020/3/5.
 * 216. 组合总和 III
 *
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。

 说明：

 所有数字都是正整数。
 解集不能包含重复的组合。 

 */
public class CombinationSum3 {

    public static void main(String[] args) {
        CombinationSum3 c = new CombinationSum3();
        c.combinationSum3(3,7);
        System.out.println(c.ans);
    }

    private List<List<Integer>> ans;

    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList<>();
        dfs(1, k, n, new Stack<>());
        return ans;
    }

    void dfs (int start, int depth, int reside, Stack<Integer> stack){
        if (depth < 0){
            return;
        }
        if (depth == 0){
            if (reside == 0){
                ans.add(new ArrayList<>(stack));
            }
            return;
        }
        for (int i = start; i <= 9; i++){
            stack.push(i);
            dfs(i + 1, depth - 1, reside - i, stack);
            stack.pop();
        }
    }
}
