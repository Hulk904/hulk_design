package algorithms.other.dfs;

import java.util.*;

/**
 * Created by yangyuan on 2020/11/8.
 * 491. 递增子序列
 *
 * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
 */
public class FindSubsequences {

    public static void main(String[] args) {
        FindSubsequences f = new FindSubsequences();
        int[] num = new int[]{4,7,7};
        f.findSubsequences(num);
    }

    List<List<Integer>> ans = new ArrayList();
    Stack<Integer> path = new Stack();


    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(nums, 0);
        return ans;
    }
    /**
     */
    void dfs(int[] nums, int start){
        if (path.size() >= 2) ans.add(new ArrayList<>(path));
        if (start == nums.length){
            return;
        }
        //在 [start, nums.length - 1] 范围内遍历搜索递增序列的下一个值。
        // 借助 set 对 [start, nums.length - 1] 范围内的数去重。
        Set<Integer> set = new HashSet<>();
        for (int i = start; i< nums.length; i++){
            if (path.size() == 0 || nums[i] >= path.peek()){
                if (set.contains(nums[i])) continue;
                set.add(nums[i]);
                path.push(nums[i]);
                dfs(nums, i + 1);
                path.pop();
            }
        }
    }
}
