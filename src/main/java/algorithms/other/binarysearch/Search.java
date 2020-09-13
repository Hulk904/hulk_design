package algorithms.other.binarysearch;

/**
 * Created by yangyuan on 2020/7/11.
 * 81. 搜索旋转排序数组 II
 *
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。

 ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。

 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。

 */
public class Search {

    /**
     * 最坏情况下时间复杂度是o(n)
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) return false;
        int right = nums.length - 1;
        while (right >= 0 && nums[right] == nums[0]){
            right--;
        }
        //去掉后半段可能与nums[0]重复的，这样可以采用二分找到分界点
        if (right < 0) return nums[0] == target;
        int l = 0, r = right;
        while (l < r){
            int mid = (l + r + 1) >> 1;
            if (nums[mid] >= nums[0]) l = mid;
            else r = mid - 1;
        }
        //找到分界点后 里面的数据保证单调性，然后就可以采用二分查找了
        //l == right 说明 没有转折的地方， 不加这个条件的话 最后  nums[l] == target 可能异常
        if (target >= nums[0] || l == right) {
            r = l;
            l = 0;
        } else {
            l++;
            r = right;
        }
        while (l < r){
            int mid = (l + r) >> 1;
            if (nums[mid] >= target) r = mid;
            else l = mid + 1;
        }
        return nums[l] == target;
    }
}
