package algorithms.top100;

import com.alibaba.fastjson.JSON;

/**
 * Created by yangyuan on 2019/12/30.
 */
public class NextPermutation {

    public static void main(String[] args) {
        int[] nums = {1,3,2};
        nextPermutation(nums);
        System.out.println(JSON.toJSONString(nums));

    }

    public static void nextPermutation(int[] nums){
        int p = reversePoint(nums);
        if (p == -1){
            reverseArray(nums, 0);
            return;
        }
        //置换目标数据
        int temp = nums[p];
        for (int i = nums.length -1; i>=0; i--){
            if (nums[i] > temp){
                nums[p] = nums[i];
                nums[i] = temp;
                break;
            }
        }
        //当置换数据后，后半部分数据仍然保持降序 所以只需 对换，不需要排序
        reverseArray(nums, p + 1);//边界

    }

    //置换顺序 包括start
    private static void reverseArray(int[] nums, int start){
        int  end = nums.length-1;
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    private static int reversePoint(int[] nums){
        if (nums.length <=1 ){
            return 0;
        }
        for (int i = nums.length - 1; i >=0; i--){
            if (i -1 >= 0 && nums[i - 1] < nums[i]){
                return i - 1;
            }
        }
        return -1;
    }
}
