package algorithms.other.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangyuan on 2021/7/11.
 * 974. 和可被 K 整除的子数组
 *
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 */
public class SubarraysDivByK {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int[] s = new int[n + 1];
        for (int i = 1; i <= n; i++){
            s[i] = s[i - 1] + nums[i - 1];
        }
        Map<Integer, Integer> map = new HashMap();
        map.put(0, 1);
        int res = 0;
        for (int i = 1; i <= n; i++){
            int r = (s[i]%k + k)%k;//因为有负数，把余数统一转为正数
            res += map.getOrDefault(r, 0);
            map.put(r, map.getOrDefault(r, 0) + 1);
        }
        return res;
    }
}
