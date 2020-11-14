package algorithms.other.array;

/**
 * Created by yangyuan on 2020/11/8.
 * 485. 最大连续1的个数
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 *
 */
public class FindMaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, max = 0;
        for (int i:nums){
            if (i == 0){
                max = Math.max(max, count);
                count = 0;
            } else {
                count++;
            }
        }
        return Math.max(count, max);
    }
}
