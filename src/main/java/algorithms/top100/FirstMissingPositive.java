package algorithms.top100;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yangyuan on 2020/1/17.
 */
public class FirstMissingPositive {

    public static void main(String[] args) {
        int[] data = {1};
        System.out.println(firstMissingPositive(data));

    }

    public static int firstMissingPositive(int[] nums) {
        if (nums.length == 0){
            return 1;
        }
        for (int i = 0; i < nums.length; i++){
            while (nums[i] > 0 && nums[i] <nums.length && nums[i] != nums[nums[i] - 1]){
                    int temp = nums[i];
                    nums[i] = nums[nums[i] - 1];
                    nums[temp - 1] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++){
            if (i != nums[i] - 1){
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    /**
     * 空间复杂度是 o(n) 依赖 HashSet实现
     * @param nums
     * @return
     */
    public int firstMissingPositive2(int[] nums) {
        Set<Integer> set = new HashSet();
        for (int i:nums){
            set.add(i);
        }
        int res = 1;
        while (set.contains(res)){
            res++;
        }
        return res;
    }
}
