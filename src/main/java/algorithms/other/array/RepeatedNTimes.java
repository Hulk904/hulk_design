package algorithms.other.array;

/**
 * Created by yangyuan on 2021/7/10.
 * 961. 重复 N 次的元素
 *
 * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。

 返回重复了 N 次的那个元素。
 */
public class RepeatedNTimes {
    public int repeatedNTimes(int[] nums) {
        //抽屉原理， 分为n组， 如果组内有相同的则就是那个数
        for (int i = 0; i < nums.length; i+=2){
            if (nums[i] == nums[i + 1]){
                return nums[i];
            }
        }
        //如果上面的条件不满足，则说明相邻两组内必有相同的元素
        if (nums[0] == nums[2] || nums[0] == nums[3]){
            return nums[0];
        }
        return nums[1];
    }
}
