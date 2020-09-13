package algorithms.top100;

/**
 * Created by yangyuan on 2019/12/30.
 * 33. 搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。

 ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

 你可以假设数组中不存在重复的元素。

 你的算法时间复杂度必须是 O(log n) 级别。

 */
public class SearchInReverseArray {
    public static void main(String[] args) {
        int[] array = {3,5,1};
        System.out.println(search(array, 5));
    }

    private static int search(int[] nums, int target) {
        if (nums == null || nums.length < 1){
            return -1;
        }
        if (nums[0] == target){
            return 0;
        }
        int reversePoint = reversePoint(nums);
        if (nums[reversePoint] == target) {
            return reversePoint;
        }
        if (nums[0] > target || reversePoint == 0){//注意如果reversePoint为0 的特殊场景
            //find right
            return findYou(nums, reversePoint, nums.length , target);
        }
        //find left
        return findYou(nums, 0, reversePoint, target);

    }

        private static int findYou(int[] nums, int left, int right, int target){
        while (left < right){
            int mid = (left + right)/2;
            if (nums[mid] == target){
                return mid;
            } else {
                if (nums[mid] > target){
                    right = mid;
                }else {
                    left = mid + 1;//注意边界问题，确保收敛可以退出  如果写 left = mid; // 将会导致left<right恒成立 而退出不了
                }
            }
        }
        return -1;
    }

    private static int reversePoint(int[] nums){
        if (nums[0] < nums[nums.length - 1] || nums.length == 1){//注意 长度为1 的情况， 后面逻辑处理不了长度为1的
            return 0;
        }
        int lo = 0 , hi = nums.length;
        while (lo < hi){
            int mid = (lo + hi )/2;
            if (nums[mid - 1] > nums[mid]){
                return mid;
            } else {
                if (nums[lo] < nums[mid]) {
                    lo = mid;
                } else {
                    hi = mid;
                }
            }
        }
        return 0;
    }

    /**
     * 使用两次二分
     * 第一次确定最小值
     * 第二次正常的二分搜索
     * @param nums
     * @param target
     * @return
     */
    int search2(int[] nums, int target){
        if (nums.length == 0){
            return -1;
        }
        int l = 0 , r = nums.length - 1;
        int min = 0;
        if (nums[0] > nums[nums.length - 1]){
            while ( l < r){
                int mid = l + r >> 1;
                if (nums[mid] < nums[0]){
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            min = nums[l];
            if (target>= min && target <= nums[nums.length - 1]){
                r = nums.length - 1;
            } else {
                r = l - 1;
                l = 0;
            }
        }
        while(l < r){
            int mid = l + r >> 1;
            if (nums[mid] >= target) r = mid;
            else l = mid + 1;
        }
        if (target == nums[l]) return l;
        return -1;
    }


}
