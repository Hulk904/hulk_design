package algorithms.top100;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yangyuan on 2020/1/3.
 * 78 子集
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

 说明：解集不能包含重复的子集。

 */
public class SubSets {
    public static void main(String[] args) {

        int[] arr= {1,2,3};
        System.out.println(JSON.toJSONString(subsets2(arr)));

    }

    private static List<List<Integer>> subsetsTimes2(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++){
            int size = result.size();
            for (int j = 0; j < size; j++){
                List<Integer> temp = new ArrayList<>(result.get(j));
                temp.add(nums[i]);
                result.add(temp);
            }
        }
        return result;
    }

    /**
     * 循环枚举  1，2，3 ===>  [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     * 遍历元素，然后往现有集合中添加当前元素
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
     * @param nums  每个位置放哪个元素
     * @return
     */
    private static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        sub(nums, result, new Stack<>(), 0);
        return result;
    }


    private static void sub(int[] nums, List<List<Integer>> result, Stack<Integer> cur, int i){
        result.add(new ArrayList<>(cur));
        for (int j = i; j< nums.length; j++) {
            cur.push(nums[j]);
            sub(nums, result, cur, j + 1);
            cur.pop();
        }
        //result.add(new ArrayList<>(cur)); 后序遍历输出结果 [[1,2,3],[1,2],[1,3],[1],[2,3],[2],[3],[]]
    }

    /**
     * 另一种回溯实现 ： 站在元素角度 选和不选
     * @param nums
     * @return
     */
    private static List<List<Integer>> subsets4(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, nums.length, result, new Stack<Integer>(),0);
        return result;
    }

    private static void dfs(int[] nums, int length, List<List<Integer>> result, Stack<Integer> path, int index){
        if (index == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        /**
         * 每一个元素有选和不选两种选择  元素放在哪个位置
         */
        dfs(nums, length, result, path, index + 1);
        path.push(nums[index]);
        dfs(nums,length, result, path, index + 1);
        path.pop();
    }

    /**
     * 通过位操作实现
     * @param nums
     * @return
     */
    private static List<List<Integer>> subsets3(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= ((1<<nums.length) - 1); i++){
            List<Integer> item = new ArrayList<>();
            for (int j = 0; i >> j > 0; j++){
                if ((i >> j & 1 )== 1){
                    item.add(nums[j]);
                }
            }
            result.add(item);
        }
        return result;
    }

}
