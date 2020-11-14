package algorithms.other.array;

/**
 * Created by yangyuan on 2020/10/31.
 *
 * 453. 最小移动次数使数组元素相等
 * 给定一个长度为 n 的非空整数数组，找到让数组所有元素相等的最小移动次数。每次移动将会使 n - 1 个元素增加 1。
 */
public class MinMoves {
    //任选n-1个元素，然后全部加1  （等价于 每次选一个元素 减一 然后 一致）
    //所以结果就是 所有值与最小值的差的和 。 （因为每次只能操作一个数了）， 不是最大值与最小值的差。。。
    public int minMoves(int[] nums) {
        int min = nums[0];
        for (int i = 0; i < nums.length; i++){
            min = Math.min(min, nums[i]);
        }
        int res = 0;
        for (int i:nums){
            res += i - min;
        }
        return res;
    }
}
