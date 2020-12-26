package algorithms.other.array;

/**
 * Created by yangyuan on 2020/11/22.
 * 540. 有序数组中的单一元素
 *
 * 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 */
public class SingleNonDuplicate {
    //leetcode 官方解答
    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r){
            int mid = (l + r) >> 1;
            if (mid % 2 == 1) mid--;
            if (nums[mid] == nums[mid + 1]) l = mid + 2;// 注意 mid + 2  数字成对的， 不然死循环了。
            else r = mid;
        }
        return nums[r];
    }
}
