package algorithms.top100;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangyuan on 2020/1/19.
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。

 示例 1 :

 输入:nums = [1,1,1], k = 2
 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。

 */
public class SubarraySum {

    public static void main(String[] args) {
        int[] data = {1,2,3};
        System.out.println(subarraySumMap2(data, 3));
    }

    public static int subarraySumMap2(int[] nums, int k){
        int total =0 ;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            if (map.containsKey(sum - k)){
                total += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return total;
    }







    public static int subarraySumMap(int[] nums, int k){
        int count =0;
        int sum = 0;
        Map<Integer/*sum*/, Integer/*count*/> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            if (map.containsKey(sum - k)){
                //相当于 sum【0-i】- sum[0-j] == k  (i > j) ,那么这个值就是需要的
                count += map.get(sum - k );
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    /**
     * 迭代的方式变了  start固定，end 变化 。。。  n2 复杂度
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySumIter(int[] nums, int k) {
        int total = 0;
        for (int i = 0; i <nums.length; i++){
            int sum = 0;
            for (int j = i; j < nums.length; j++){
                sum+=nums[j];
                if (sum == k){
                    total++;
                }
            }
        }
        return total;
    }


    /**
     * 超出时间 n3复杂度   num[i:j] 可以用sum[j] - sum[i] 计算而来。这样可以快点
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum(int[] nums, int k) {
        int total = 0;
        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j <= i; j++){
                int sum = sum(nums, j, i);
                if (sum == k){
                    total++;
                }
            }
        }
        return total;
    }

    private static int sum (int[] nums, int begin, int end){
        int sum = 0;
        for (int j = begin; j <= end; j++){
            sum += nums[j];
        }
        return sum;
    }
}
