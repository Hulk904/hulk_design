package algorithms.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yangyuan on 2020/9/26.
 * 368. 最大整除子集
 *
 * 给出一个由无重复的正整数组成的集合，找出其中最大的整除子集，子集中任意一对 (Si，Sj) 都要满足：Si % Sj = 0 或 Sj % Si = 0。

 如果有多个目标子集，返回其中任何一个均可。
 dp问题求方案，倒推一次就行了
 */
public class LargestDivisibleSubset {

    /**
     * dp求路径 倒着来一次就行，这里使用两个一个last数组记录 （用空间换时间了） 还有一种方式就是不使用last数组，然后 两层循环计算出来见 acwing
     * @param nums
     * @return
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        if (n == 0) return new ArrayList<>();
        int[] dp = new int[n];
        int[] last = new int[n];
        int max = 0;
        int end = -1;
        Arrays.fill(last,  -1);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            dp[i] = 1;
            //枚举倒数第二个数
            for (int j = 0; j < i; j++){
                if (nums[i]%nums[j] == 0 && dp[i] <= dp[j]){
                    dp[i] = dp[j] + 1;
                    last[i] = j;
                }
            }
            if (dp[i] > max){
                max = dp[i];
                end = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = end; i != -1; i = last[i]){
            res.add(nums[i]);
        }
        //不使用辅助数组记录 ，输出结果的方式如下。。。
//        while (dp[end] > 1){
//            for (int i = 0; i < end; i++){
//                if (nums[end]%nums[i] && dp[end] == dp[i] + 1){
//                    res.add(nums[i]);
//                    end = i;
//                    break;
//                }
//            }
//        }
        return res;
    }
}
