package algorithms.other.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yangyuan on 2020/11/21.
 * 523. 连续的子数组和
 *
 * 给定一个包含 非负数 的数组和一个目标 整数 k，编写一个函数来判断该数组是否含有连续的子数组，
 * 其大小至少为 2，且总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。

 */
public class CheckSubarraySum {

    /**
     *  相当于判断  s[i] - s[i - 2] 、s[i] - s[i - 3]、 s[i] - s[i - 4]、 s[i] -s[i - 5]....、 s[i] - s[0] 可以被k整除   s是前缀和数组
     *  即  s[i] 和 s[i - 2]、s[i - 3]...s[0]  mod k 相同。
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        if (k == 0){
            for (int i = 1; i < nums.length; i++){
                if (nums[i - 1] == 0 && nums[i] == 0) {
                    return true;
                }
            }
            return false;
        }
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + nums[i - 1];
        Set<Integer> set= new HashSet();
        for (int i = 2; i <= n; i++){
            set.add(sum[i - 2] % k);
            if (set.contains(sum[i]%k)) return true;
        }
        return false;
    }
}
