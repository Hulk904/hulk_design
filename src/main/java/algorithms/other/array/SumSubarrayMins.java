package algorithms.other.array;

import java.util.Stack;

/**
 * Created by yangyuan on 2021/6/13.
 * 907. 子数组的最小值之和
 *
 * 给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。

 由于答案可能很大，因此 返回答案模 10^9 + 7 。



 */
public class SumSubarrayMins {
    public int sumSubarrayMins(int[] arr) {//891
        int n = arr.length;
        int[] l = new int[n], r = new int[n];
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < n; i++){
            while (stack.size() > 0 && arr[stack.peek()] > arr[i]) stack.pop();
            if (stack.isEmpty()) l[i] = -1;
            else l[i] = stack.peek();
            stack.push(i);
        }
        stack = new Stack();
        for (int i = n - 1; i >= 0; i--){
            while (stack.size() > 0 && arr[stack.peek()] >= arr[i]) stack.pop();
            if (stack.isEmpty()) r[i] = n;
            else r[i] = stack.peek();
            stack.push(i);
        }
        int MOD = 1000000007;
        int res = 0;
        for (int i = 0; i < n ; i ++){
            res = (int)((res + arr[i]*((long)i - l[i])*(r[i] - i))%MOD);
        }
        return res;
    }
}
