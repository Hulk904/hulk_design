package algorithms.other;

/**
 * Created by yangyuan on 2020/4/20.
 * 35. 搜索插入位置
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 */
public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        //这里和普通二分不一样的地方是。如果target大于nums的最大值，应该返回nums的长度，这个是超边界了的
        //r需要初始化为num.length（正常二分是num.length - 1）
        int l = 0, r = nums.length;
        while (l < r){
            int mid = (l + r) >> 1;
            if (nums[mid] >= target) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}
