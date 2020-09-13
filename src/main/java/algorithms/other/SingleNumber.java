package algorithms.other;

/**
 * Created by yangyuan on 2020/7/26.
 * 137. 只出现一次的数字 II
 *
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。

 说明：

 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        int one = 0, two = 0;
        for (int i :nums){
            one = (one ^ i) &(~two);
            two = (two ^ i) &(~one);
        }
        return one;
    }
}
