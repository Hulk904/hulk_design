package algorithms.top100;

import com.alibaba.fastjson.JSON;

/**
 * Created by yangyuan on 2020/1/15.
 *
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。

 示例 1:

 输入: 2
 输出: [0,1,1]

 */
public class CountBit {

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(countBits2(5)));
    }


    /**
     * 动态规划  动态规划遵循一套固定的流程：递归的暴力解法 -> 带备忘录的递归解法 -> 非递归的动态规划解法
     *
     * 还有一个状态函数 dp[i] = dp[i&(i-1)] + 1
     * @param num
     * @return
     */
    public static int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 1; i <= num; i++){
            result[i] = result[i >> 1] + (i&1);
        }
        return result;
    }


    public static int[] countBits2(int num){
        int[] result = new int[num + 1];
        for (int i = 1; i <= num; i++){
            result[i] = popCount(i);
        }
        return result;
    }

    /**
     * 计算整数a 二进制1的个数  这个方法叫pop count
     * @param a
     * @return
     */
    private static int popCount(int a){
        int count = 0;
        while (a != 0){
            count++;
            a = a &(a-1);
        }
        return count;
    }
}
