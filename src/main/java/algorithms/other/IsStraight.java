package algorithms.other;

import java.util.Arrays;

/**
 * Created by yangyuan on 2020/4/14.
 * 面试题61. 扑克牌中的顺子
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，
 * 可以看成任意数字。A 不能视为 14。

 猿辅导 算法题，当时虽然写出来了，但是比较乱。

 后来问面试反馈，说是算法写的不好。看来不仅要写出来更要写的好才行啊。。。
 */
public class IsStraight {

    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int queenNum = 0;
        for (int i = 0; i < nums.length - 1; i++){
            if (nums[i] == 0){
                queenNum++;
                continue;
            }
            //面试的时候考虑的是 往前比，各种条件判断，导致代码不是很美观
            if (nums[i] == nums[i +1]) return false;//重复的返回 false
            queenNum -= (nums[i + 1] - nums[i] - 1);
        }
        return queenNum >= 0;
    }
}
