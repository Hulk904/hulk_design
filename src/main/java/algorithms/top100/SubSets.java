package algorithms.top100;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yangyuan on 2020/1/3.
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

 说明：解集不能包含重复的子集。

 */
public class SubSets {
    public static void main(String[] args) {

        int[] arr= {1,2,3};
        System.out.println(JSON.toJSONString(subsets(arr)));

    }

    /**
     * 循环枚举  1，2，3 ===>  [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     * @param nums
     * @return
     */
    private static List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int n:nums){
            int size = result.size();
            for (int j = 0 ;j <size; j ++){
                List<Integer> item = new ArrayList<>(result.get(j));
                item.add(n);
                result.add(item);
            }
        }
        return result;
    }


    /**
     * 递归  1，2，3 ===>  [[],[1],[1,2],[1,2,3],[1,3],[2],[2,3],[3]]
     * @param nums
     * @return
     */
    private static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        sub(nums, result, new Stack<>(), 0);
        return result;
    }


    private static void sub(int[] nums, List<List<Integer>> result, Stack<Integer> cur ,int i){
        result.add(new ArrayList<>(cur));
        for (int j = i; j< nums.length; j++) {
            cur.push(nums[j]);
            sub(nums, result, cur, j + 1);
            cur.pop();
        }
    }

}
