package algorithms.other;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Created by yangyuan on 2020/3/4.
 * 47. 全排列 II
 *
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 与46相比 主要是包含了重复元素
 * 比如 把 1 放在位置 1  然后把另一个1 放在位置2
 * 和  把第二个1 放在位置1 然后把第一个1放在位置2 是一样的
 * 所以要规定他们的顺序  -->排序可以让相同的元素在一起
 */
public class PermuteUnique {

    List<List<Integer>> res = new ArrayList<>();

    boolean[] visited ;

    public static void main(String[] args) {
        PermuteUnique p = new PermuteUnique();
        int[] data = {1,2,1};
        JSON.toJSONString(p.permuteUnique2(data));
    }

    /**
     * 枚举每个数放在什么位置
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        visited = new boolean[nums.length];
        Arrays.sort(nums);
        Integer[] path = new Integer[nums.length];
        dfs(nums, 0 ,0 ,path);
        return res;
    }

    /**
     *
     * @param nums
     * @param u 枚举到的位置
     * @param start
     */
    void dfs(int[] nums, int u, int start, Integer[] path) {
        if (u == nums.length){
            res.add(Arrays.stream(path).collect(Collectors.toList()));
            return;
        }
        for (int i = start; i < nums.length; i++){
            if (!visited[i]){
                visited[i] = true;
                path[i] =  nums[u];//注意这里重置了所以后面不需要恢复
                dfs(nums, u + 1, (u + 1 < nums.length && nums[u + 1] == nums[u]) ? i + 1 : 0, path);
                visited[i] = false;
            }
        }

    }

    /**
     * 跟46差不多
     * 多了排序，然后dfs的时侯加个剪枝
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique2(int[] nums) {
        if (nums.length == 0){
            return new ArrayList<>();
        }
        visited = new boolean[nums.length];
        Arrays.sort(nums);
        dfs2(nums, 0, new Stack<>());
        return res;
    }

    /**
     * 里面遍历的时候i直接从0开始的
     * 所以 depth 理解为遍历的深度，便于最后退出。
     * @param nums
     * @param depth
     * @param stack
     */
    void dfs2(int[] nums, int depth, Stack<Integer> stack) {
        if (depth == nums.length){
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
            // 写 !visited[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            if (!visited[i]){
                visited[i] = true;
                stack.push(nums[i]);
                dfs2(nums, depth + 1, stack);
                stack.pop();
                visited[i] = false;
            }
        }
    }

}
