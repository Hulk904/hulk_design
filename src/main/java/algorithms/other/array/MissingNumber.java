package algorithms.other.array;

/**
 * Created by yangyuan on 2020/8/29.
 * 268. 缺失数字
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 */
public class MissingNumber {

    /**
     * 数学法
     * 1～n 的和 ，减去数字中的数， 剩下的就是缺失的数
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int res = (1 + nums.length)*nums.length/2;
        for (int n:nums){
            res = res - n;
        }
        return res;
    }


}
