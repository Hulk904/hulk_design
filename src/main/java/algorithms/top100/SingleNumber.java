package algorithms.top100;

/**
 * Created by yangyuan on 2020/1/7.
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

 说明：

 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] data = {4,1,2,1,2};
        System.out.println(singleNumber(data));
    }

    public static int singleNumber(int[] nums) {
        if ( nums == null || nums.length == 0){
            return -1;
        }
        int target = nums[0];
        for (int i = 1; i < nums.length; i++){
            target = target^nums[i];
        }
        return target;
    }
}
