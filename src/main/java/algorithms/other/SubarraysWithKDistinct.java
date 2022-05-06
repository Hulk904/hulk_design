package algorithms.other;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangyuan on 2021/11/13.
 * 992. K 个不同整数的子数组
 *
 * 给定一个正整数数组 A，如果 A 的某个子数组中不同整数的个数恰好为 K，则称 A 的这个连续、不一定不同的子数组为好子数组。

 （例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。）

 返回 A 中好子数组的数目。


 */
public class SubarraysWithKDistinct {

    //双指针
    public int subarraysWithKDistinct(int[] nums, int k) {
        Map<Integer, Integer> s1 = new HashMap(), s2 = new HashMap();
        int res = 0;
        //j1 是以i结尾有k个不同元素的最左边坐标，
        // j2是以i结尾有k-1个不同元素的最左边坐标
        for (int i = 0, j1 = 0, j2 = 0, cnt1 = 0, cnt2 = 0; i < nums.length; i++){
            if (s1.getOrDefault(nums[i], 0) == 0) cnt1++;
            s1.put(nums[i], s1.getOrDefault(nums[i], 0) + 1);
            while (cnt1 > k){
                s1.put(nums[j1], s1.get(nums[j1]) - 1);
                if (s1.get(nums[j1]) == 0) cnt1 --;
                j1++;
            }

            if (s2.getOrDefault(nums[i], 0) == 0) cnt2++;
            s2.put(nums[i], s2.getOrDefault(nums[i], 0) + 1);
            while (cnt2 >= k){
                s2.put(nums[j2], s2.get(nums[j2]) - 1);
                if (s2.get(nums[j2]) == 0) cnt2 --;
                j2++;
            }
            res += j2 - j1;
        }
        return res;
    }
}
