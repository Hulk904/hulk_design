package algorithms.toutiao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyuan on 2020/4/11.
 * 442. 数组中重复的数据
 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。

 找到所有出现两次的元素。

 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？

 与287 还是不一样的 ，287是只有一个重复的数字（可能重复不止一次）。
 这里是有多个 且是两次。
 思路倒是跟448很像。（找到数组中消失的数），都是对数字进行标识
 */
public class FindDuplicates {

    /**
     * 虽然第一眼知道怎么去做，但是在用代码表达的时候还是很混乱的。
     * 需要多练习
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList();
        for(int i = 0; i < nums.length; i++){
            int loc = Math.abs(nums[i]) - 1;
            if (nums[loc] < 0){
                list.add(loc + 1);
                continue;//加不加都可以，因为 都是两次或者一次
            }
            nums[loc] = -nums[loc];
        }
        return list;
    }
}
