package algorithms.top100;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by yangyuan on 2019/12/31.
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。

 示例:

 输入: [1,2,3]
 输出:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]

 */
public class Permute {


    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(JSON.toJSONString(permute(nums)));
    }

    public static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        doPermute(nums, result, 0);
        return result;
    }

    public static void  doPermute(int[] nums, List<List<Integer>> result, int start){
        if (start == nums.length -1){
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        for (int i = start; i < nums.length; i++){
            swap(nums, start, i);
            doPermute(nums, result, start + 1);
            swap(nums, start, i);
        }
    }

    public static void swap(int[] nums, int i ,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
