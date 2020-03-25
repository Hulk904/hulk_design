package algorithms.top100;

import com.alibaba.fastjson.JSON;


/**
 * Created by yangyuan on 2020/1/14.
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

 示例:

 输入: [0,1,0,3,12]
 输出: [1,3,12,0,0]
 说明:

 必须在原数组上操作，不能拷贝额外的数组。
 尽量减少操作次数。

 */
public class MoveZero {

    public static void main(String[] args) {
        int[] data = {0,1,0,3,12};
        moveZeroes(data);
        System.out.println(JSON.toJSONString(data));
    }

    public static  void moveZeroes(int[] nums){
        int a = 0;
        for (int cur = 0; cur < nums.length; cur++){
            if (nums[cur] != 0){
                /*
                必须是交换不能写成：
                 nums[a] = nums[i];
                 nums[i] = 0;
                 a++;
                 */
                swap(nums, a++, cur);
            }
        }
    }

    private static void swap(int[] nums, int a ,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    /**
     * 非0直接前移，剩下的用0覆盖
     * @param nums
     */
    public static void moveZeroes2(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0){
                nums[index++] = nums[i];
            }
        }
        while (index < nums.length){
            nums[index++] = 0;
        }
    }

}
