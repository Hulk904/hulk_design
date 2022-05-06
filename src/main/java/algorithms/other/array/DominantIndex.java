package algorithms.other.array;

/**
 * Created by yangyuan on 2021/3/27.
 * 747. 至少是其他数字两倍的最大数
 *
 * 在一个给定的数组nums中，总是存在一个最大元素 。

 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。

 如果是，则返回最大元素的索引，否则返回-1。

 */
public class DominantIndex {
    public int dominantIndex(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > nums[k]) k = i;
        }
        for (int i = 0; i < nums.length; i++){
            if (i != k && nums[i]*2 > nums[k]) return -1;
        }
        return k;
    }
}
