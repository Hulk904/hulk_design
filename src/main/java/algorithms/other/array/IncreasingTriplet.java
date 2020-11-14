package algorithms.other.array;

/**
 * Created by yangyuan on 2020/9/19.
 * 334. 递增的三元子序列
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。

 数学表达式如下:

 如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
 使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。

 */
public class IncreasingTriplet {

    /**
     * 最长上升子序列的简化版
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] <= a){
                a = nums[i];
            } else if (nums[i] <= b){
                b = nums[i];
            } else {//到这里表明 存在大于   a 同时也大于b的数了。
                return true;
            }
        }
        return false;

    }
}
