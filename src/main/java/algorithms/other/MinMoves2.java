package algorithms.other;

/**
 * Created by yangyuan on 2020/3/1.
 * 462. 最少移动次数使数组元素相等 II
 *
 * 给定一个非空整数数组，找到使所有数组元素相等所需的最小移动数，其中每次移动可将选定的一个元素加1或减1。 您可以假设数组的长度最多为10000
 * 这是个数学问题
 * 怎么找到目标数？
 * 如果将数组排序 则中间的数就是我们需要的数。所以找到中间的数就行了 --> 第k大的数
 * 如果是奇数就是中间的那个
 * 如果是偶数那两个任选一个就行， 所以 用 n/2就行了。。。
 *
 */

public class MinMoves2 {

    public static void main(String[] args) {
        minMoves2(new int[]{1,1,1});
    }

    public static int minMoves2(int[] nums) {
        int k = nums.length >> 1;
        int targht = kthNum(nums, k);
        int result = 0;
        for (int i = 0; i < nums.length; i++){
            result += Math.abs(targht - nums[i]);
        }
        return result;
    }

    static int  kthNum(int[] nums, int k){
        int left = 0, right = nums.length - 1;
        while (true) {
            int p = partition(nums, left, right);
            if (p > k) {
                right = --p;
            } else if (p < k) {
                left = ++p;
            } else {
                return nums[k];
            }
        }
    }

    static int  partition(int[] arr, int s, int e){
        int pirot = arr[s];
        while (s < e){
            while (s < e && arr[e] >= pirot){
                e--;
            }
            arr[s] = arr[e];
            while (s < e && arr[s] <= pirot){
                s++;
            }
            arr[e] = arr[s];
        }
        arr[s] = pirot;
        return s;
    }
}
