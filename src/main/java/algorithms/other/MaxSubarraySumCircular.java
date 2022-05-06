package algorithms.other;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by yangyuan on 2020/3/6.
 * 918. 环形子数组的最大和
 *
 * 单调队列的问题
 * 这个跟 数组的最大子数组和思路还是相差挺大的，如果按照数组的思维 估计会陷入死胡同
 * 滑动窗口求最小值--单调队列
 */
public class MaxSubarraySumCircular {

    public static void main(String[] args) {
        int[] data = {-2,-3,-1};
        System.out.println(maxSubarraySumCircular(data));
    }

    /**
     * 先计算前缀和
     * 计算出前缀和后。求以某个点结尾的最大和，就是求前面n范围内的最小前缀和 （相减便是 最大了）
     * 然后依次求出每个点 ，最终得到结果
     * @param
     * @return
     */
    public static int maxSubarraySumCircular(int[] A) {
        int[] p = new int[A.length*2];
        for (int i = 0; i < p.length; i++){
            p[i] = i - 1 < 0 ? A[0] :p[i - 1] + A[i%A.length];
        }
        Deque<Integer> de = new ArrayDeque();
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < p.length; i++){
            if (!de.isEmpty() && i - A.length > de.peekFirst()){
                de.pollFirst();
            }
            //计算结果不能跟下面的交换 。如果前缀和是递减的（-2，-3，-1 序列）则会有问题
            if (!de.isEmpty()){
                result = Math.max(result, p[i] - p[de.peekFirst()]);
            }
            while (!de.isEmpty() && p[de.peekLast()] > p[i]) de.pollLast();
            de.addLast(i);
        }
        return result;
    }
}
