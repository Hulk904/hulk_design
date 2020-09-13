package algorithms.other;

import java.util.Stack;

/**
 * Created by yangyuan on 2020/4/12.
 * 503. 下一个更大元素 II
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），
 * 输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，
 * 这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。
 * 如果不存在，则输出 -1。

 */
public class NextGreaterElements {



    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack();//存放数字 递减
        for (int i = n*2 - 1; i >= 0; i--){
            while (!stack.isEmpty() && stack.peek() <= nums[i%n]) stack.pop();
            if (!stack.isEmpty()) {
                res[i%n] = stack.peek();//可以直接赋值不要特殊判断，后面的会覆盖之前的值
            } else {
                res[i%n] = -1;
            }
            stack.add(nums[i%n]);
        }
        return res;
    }
}
