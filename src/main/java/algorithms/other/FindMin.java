package algorithms.other;

/**
 * Created by yangyuan on 2020/2/27.
 *
 * 153. 寻找旋转排序数组中的最小值
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。

 ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

 请找出其中最小的元素。

 你可以假设数组中不存在重复元素。

 */
public class FindMin {

    public static void main(String[] args) {
        int[] data = {4,5,6,7,0,1,2};
        findMin(data);
    }

    public static int findMin(int[] nums) {
        //处理单调递增的特例
        if (nums[0] <= nums[nums.length - 1]) return nums[0];
        int l = 0, r = nums.length - 1;
        //这个数的特点就是小于左边所有的数，而左边最小的就是num[0]
        while (l < r){
            int mid = (l + r) >> 1;
            if (nums[mid] >= nums[0]) l = mid + 1;
            else  r = mid;
        }
        return nums[r];
    }
}
