package algorithms.top100;

import java.util.Stack;

/**
 * Created by yangyuan on 2020/1/20.
 */
public class FindUnsortedSubarray {

    public static void main(String[] args) {
        //int[] data = {1,3,2,3,3};
        int[] data = {1,2,3,4};
        System.out.println(findUnsortedSubarray2(data));
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
        }
        stack.clear();
        for (int i = nums.length - 1; i >=0; i--){
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]){
                end = Math.max(end, stack.pop());
            }
            stack.push(i);
        }
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
