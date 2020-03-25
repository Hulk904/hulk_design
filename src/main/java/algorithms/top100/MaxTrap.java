package algorithms.top100;

import java.util.Stack;

/**
 * Created by yangyuan on 2020/1/1.
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class MaxTrap {

    public static void main(String[] args) {
        int[] data = {0,1,0,2,1,0,1,2};
        System.out.println(trap(data));
    }

    /**
     * 双指针夹逼
     * @param height
     * @return
     */
    public static int trap(int[] height){
        int leftMax = height[0], rightMax = height[height.length - 1];
        int left = 0, right = height.length - 1;
        int total = 0;
        while (left < right){
            if (height[left] < height[right]) {
                if (height[left] > leftMax){
                    leftMax = height[left];
                } else {
                    total += (leftMax - height[left]);
                }
                left++;
            } else{
                if (height[right] > rightMax){
                    rightMax = height[right];
                }else {
                    total += (rightMax - height[right]);
                }
                right--;
            }
        }
        return total;
    }

    /**
     * 单调栈实现。。。
     * @param height
     * @return
     */
    public static int trap2(int[] height){
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++){
            int level = 0;
            while (!stack.isEmpty() && height[stack.peek()] <= height[i]){
                result += (height[stack.peek()] - level)*(i - stack.peek() - 1);
                level = height[stack.peek()];
                stack.pop();
            }
            if (!stack.isEmpty()){
                result += (height[i] - level)*(i - stack.peek() - 1);
            }
            stack.push(i);
        }
        return result;
    }
}
