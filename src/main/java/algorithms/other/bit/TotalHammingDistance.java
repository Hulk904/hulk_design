package algorithms.other.bit;

/**
 * Created by yangyuan on 2020/11/7.
 * 477. 汉明距离总和
 *
 * 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。

 计算一个数组中，任意两个数之间汉明距离的总和。
 */
public class TotalHammingDistance {

    /**
     * 直接暴力是n^2 的复杂度
     * 所以需要换个思路
     * @param nums
     * @return
     */
    public int totalHammingDistance(int[] nums) {
        int res = 0;
        for (int i = 0; i <= 30; i++){
            int x = 0, y = 0;
            for (int j:nums){
                if ((j>>i & 1) == 1){
                    x++;
                } else {
                    y++;
                }
            }
            res += x*y;
        }
        return res;
    }
}
