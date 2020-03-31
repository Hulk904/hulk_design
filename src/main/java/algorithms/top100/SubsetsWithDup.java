package algorithms.top100;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * Created by yangyuan on 2020/3/3.
 * 90. 子集 II
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

 说明：解集不能包含重复的子集。

 与78相比，思路需要转换下。78是选和不选两种选择，
 这里是一个数被选几次的问题。。。
 所以先统计每个数的次数
 */
public class SubsetsWithDup {

    List<List<Integer>> ans ;

    public static void main(String[] args) {
        SubsetsWithDup s = new SubsetsWithDup();
        int[] data = {2,1,2};
        List<List<Integer>> result = s.subsetsWithDup(data);
        System.out.println(result);
    }


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, new Stack<>(), 0);
        return ans;
    }

    private void dfs(int[] nums, Stack<Integer> path, int index){
        ans.add(new ArrayList<>(path));
        for (int i = index; i < nums.length; i++){
            //剪枝条件 注意是 i>index
            //得从第二个数开始   如果是写i > 0 像 122，22 都会被过滤掉
            //和上个数字相等就跳过
            if (i > index && nums[i] == nums[i - 1]){
                System.out.println(JSON.toJSONString(path));
                continue;
            }
            path.push(nums[i]);
            dfs(nums, path, i + 1);
            path.pop();
        }
    }
}
