package algorithms.top100;

/**
 * Created by yangyuan on 2020/1/10.
 *
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

 示例 1:

 输入: [3,2,1,5,6,4] 和 k = 2
 输出: 5

 */
public class FindKthLargest {

    public static void main(String[] args) {
        int[] data = {3,2,1,5,6,4};
        System.out.println(findKthLargest(data, 2));
    }


    /**
     * 因为是找到第k大的数据
     * 如果排序为生序，则 第k大的数据的坐标应该是 数组长度-k
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        int left = 0;
        int target = nums.length - k ; //注意  是找到第k大的数据
        int right = nums.length - 1;
        while (true) {
            int pirot = partition(nums, left, right);
            if (pirot == target) {
                return nums[pirot];
            } else if (pirot < target) {
                left = ++pirot; //注意
            } else {
                right = --pirot;//注意
            }
        }
    }

    private static int partition(int[]array, int left, int right){
        int pirotKey = array[left];
        while (left < right){
            while (left < right && array[right] >= pirotKey){
                right --;
            }
            array[left] = array[right];
            while (left < right && array[left] <= pirotKey){
                left ++;
            }
            array[right] = array[left];
        }
        array[left] = pirotKey;
        return left;
    }
}
