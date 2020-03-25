package algorithms.top100;

import java.util.Stack;

/**
 * Created by yangyuan on 2020/1/20.
 * 581. 最短无序连续子数组
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。

 你找到的子数组应是最短的，请输出它的长度。
 */
public class FindUnsortedSubarray {

    public static void main(String[] args) {
        //int[] data =
        int[] data = {1,3,2,2,2};
        System.out.println(findUnsortedSubarray(data));
    }

    public static int findUnsortedSubarray(int[] nums){
        if (nums.length <= 1){
            return 0;
        }
        int start = nums.length, end = 0;
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < nums.length; i++){
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]){
                start = Math.min(start, stack.pop());
            }
            stack.push(i);
        }//stack 剩余元素递增的 1，2，2，2 start = 1
        stack.clear();
        for (int i = nums.length - 1; i >=0; i--){
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]){
                end = Math.max(end, stack.pop());
            }
            stack.push(i);
        }//剩下3、1  end = 4
        return start>end ? 0 : end - start + 1;
    }

    public static int findUnsortedSubarray2(int[] nums){
        int left = nums.length;
        int right = 0;
        int curMaxLeft = nums[nums.length - 1];
        int curMaxRight = nums[0];
        for (int i = 0; i < nums.length; i++){
            if (curMaxRight > nums[i]){
                right = i;
            } else {
                curMaxRight = nums[i];
            }
            if (curMaxLeft < nums[nums.length - i - 1]){
                left = nums.length - i - 1;
            } else {
                curMaxLeft = nums[nums.length - i - 1];
            }
        }
        return right < left ? 0 : right - left + 1;//初始化right = -1, left = 0 就可以直接返回 right-left + 1 了

    }

    /**
     * 错误答案
     * 问题在于比较的是相邻的两个元素   1,3,2,2,2  这个用例将会导致错误
     * @param nums
     * @return
     */
    public static int findUnsortedSubarrayWrong(int[] nums) {
        if (nums.length <= 1){
            return 0;
        }
        int start = nums.length, end = 0;
        for (int i = 0; i < nums.length - 1; i++){
            if (nums[i] > nums[i + 1] && start == nums.length){
                start = i;
            }
            if (nums[i] > nums[i + 1]){
                end = Math.max(end, i + 1);
            }
        }
        return start>=end ? 0 : end - start + 1;

    }
}
