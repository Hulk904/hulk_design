package algorithms.top100;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

 candidates 中的数字可以无限制重复被选取。

 * Created by yangyuan on 2019/12/30.
 */
public class CombinationSum {




    public static void main(String[] args) {
        int[] array = {3,2,6,7};
        System.out.println(JSON.toJSONString(combinationSum(array, 7)));
    }

    private static List<List<Integer>>   combinationSum(int[] candidates, int target) {

        /**
         * 排序是为了更好的处理重复的情况 eg： 2，3，2 和 2，2，3
         */
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        doSum(target,0, new Stack<>(), candidates, result);
       return result;
    }

    private static  void doSum(int reside, int start , Stack<Integer> stack, int [] array, List<List<Integer>> result){
        if (reside  == 0){
            result.add((Stack<Integer>)stack.clone());
            return;
        }
        for (int i = start; i < array.length && reside - array[i] >= 0 ; i++){
            stack.push(array[i]);
            doSum(reside - array[i], i, stack, array, result);//递归 传的是 i 而不是 i+1
            stack.pop();
        }
    }
}
