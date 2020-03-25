package algorithms.top100;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

 /**
  * 39. 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

 candidates 中的数字可以无限制重复被选取。

 * Created by yangyuan on 2019/12/30.
 */
public class CombinationSum {




    public static void main(String[] args) {
        int[] array = {8,7,3,4};
        //System.out.println(JSON.toJSONString(combinationSum(array, 11)));
        CombinationSum c = new CombinationSum();
        c.combinationSum2(array,11);
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
            doSum(reside - array[i], i, stack, array, result);//递归 传的是 i 而不是 i+1  因为数字可以使用多次
            stack.pop();
        }
    }

     List<List<Integer>> res = new ArrayList();

     /**
      * 这个方法跟方法一相比 对数组并没有排序
      * 整体看起来没啥区别，唯一的区别就是 方法1 for循环上面多了个剪枝处理 reside - array[i] >= 0
      * 而方法二不能这么加。因为这是for的工作原理决定的。因为一旦有个条件不满足了就不会走后序的
      * 可以加在for体里
      * @param candidates
      * @param target
      * @return
      */
     public List<List<Integer>> combinationSum2(int[] candidates, int target) {
         dfs(candidates, 0, new Stack(), target);
         return res;
     }

     void dfs(int[] candidates, int start,Stack<Integer> item, int reside){
         if (reside == 0){
             res.add(new ArrayList(item));
             return;
         }
         //加了后面的那块这个也没用了
         if (reside < 0){
             return;
         }
         for (int i = start; i < candidates.length ; i++){
             //这个剪枝是后来加的，跟方法一可以不一样
             if (reside - candidates[i] < 0){
                 continue;
             }
             item.push(candidates[i]);
             System.out.println(item.toString());
             dfs(candidates, i, item, reside - candidates[i]);
             item.pop();
         }
     }
}
