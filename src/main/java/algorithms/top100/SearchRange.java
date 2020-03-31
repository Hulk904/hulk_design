package algorithms.top100;

import com.alibaba.fastjson.JSON;

/**
 * Created by yangyuan on 2019/12/29.
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

 你的算法时间复杂度必须是 O(log n) 级别。

 如果数组中不存在目标值，返回 [-1, -1]。

 */
public class SearchRange {

    public static void main(String[] args) {
        int[] data = {2,2};
        System.out.println(JSON.toJSONString(searchRange(data, 3)));

    }


    public static int[] searchRange(int[] nums, int target){
        if (nums.length == 0){
            return new int[]{-1,-1};
        }
        int left = rangeIndex(nums, target, true);
        if (left >= nums.length || nums[left] != target){//注意 数字可能不存在的情况，left出边界了
            return new int[]{-1,-1};
        }
        return new int[]{left, rangeIndex(nums, target, false) -1};
    }

    public static int rangeIndex(int[] nums, int target, boolean isLeft){
        int lo = 0, hi = nums.length;
        int mid;
        while (lo < hi){
            mid = (lo + hi)/2;
            if (nums[mid] > target || (isLeft && nums[mid] == target)){
                hi = mid;
            } else {
                lo = mid + 1;//注意   如果数字存在，则右边界正好是 lo -1
            }
        }
        return lo;
    }

    /**
     *  推荐这个写法。。。
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange2(int[] nums, int target) {
        if (nums.length == 0)return new int[]{-1, -1};
        int l = 0, r = nums.length -  1;
        while (l < r){
            int mid = (l + r)/2;
            if (nums[mid]  >= target) r = mid;
            else l = mid + 1;
        }
        if (nums[l] != target){
            return new int[]{-1, -1};
        }
        int a = l;
        l = 0;
        r = nums.length - 1;
        while (l < r){
            int mid = (l + r + 1)/2;
            if (nums[mid] <= target) l = mid;
            else r = mid - 1;
        }
        return new int[]{a,l};

    }
}
