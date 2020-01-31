package algorithms.top100;

/**
 * Created by yangyuan on 2019/12/30.
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
}
