package algorithms.other;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by yangyuan on 2020/3/6.
 */
public class MaxSubarraySumCircular {

    public static void main(String[] args) {
        int[] data = {-2,-3,-1};
        System.out.println(maxSubarraySumCircular(data));
    }

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
