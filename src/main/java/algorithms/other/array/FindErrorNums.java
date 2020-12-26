package algorithms.other.array;

/**
 * Created by yangyuan on 2020/12/26.
 * 645. 错误的集合
 *
 * 集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元素重复。

 给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。

 */
public class FindErrorNums {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int [2];
        //先置反
        for (int x:nums){
            int k = Math.abs(x);
            if (nums[k - 1] < 0){
                res[0] = k;
            }
            nums[k - 1] *= -1;
        }
        //最后为正的数一个是出现了两次的，一个是没有出现的数。
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > 0 && i + 1 != res[0]){
                res[1] = i + 1;
            }
        }
        return res;
    }
}
