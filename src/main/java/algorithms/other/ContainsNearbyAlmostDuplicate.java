package algorithms.other;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by yangyuan on 2020/8/16.
 * 220. 存在重复元素 III
 * 在整数数组 nums 中，是否存在两个下标 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值小于等于 t ，
 * 且满足 i 和 j 的差的绝对值也小于等于 ķ 。

 如果存在则返回 true，不存在返回 false。

 */
public class ContainsNearbyAlmostDuplicate {

    /**
     * leetcode 官方解答
     * 类似于滑动窗口
     * 不需要记录下标，保证 集合里面的数小于k 就行
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++){
            Integer s = set.ceiling(nums[i]);
            /**
             *  1,100,100,100,10
             *  9
             *  3
             *  这样包含重复元素的 ，其实他们本身就满足条件了，而不是1，10
             *  重复元素 时 s!=null &&  s <= num[i] + t 其实为true，运行就结束了
             */
            if (s != null &&  s <= nums[i] + t) return true;
            Integer g = set.floor(nums[i]);
            if (g != null && nums[i] <= g + t ) return  true;
            set.add(nums[i]);
            if (set.size() > k){
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
