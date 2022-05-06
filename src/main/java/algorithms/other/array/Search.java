package algorithms.other.array;

/**
 * Created by yangyuan on 2021/3/14.
 * 704. 二分查找
 *
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，
 * 如果目标值存在返回下标，否则返回 -1。

 */
public class Search {
    /**
     * 模版题， 二分查找
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1; //确定二分区间的两个端点
        while ( l < r){
            int mid = (l + r) >> 1;
            if (nums[mid] >= target) r = mid;
            else l = mid + 1;
        }
        return nums[l] == target ? r : -1;
    }
}
