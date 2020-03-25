package algorithms.top100;

import java.util.Stack;

/**
 * Created by yangyuan on 2020/1/30.
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。

 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
public class LargestRectangleArea {

    public static void main(String[] args) {
        int[] data = {5,4,1,2};
        System.out.println(largestRectangleAreaTimes2(data));
    }

    /**
     * 每次计算面积都是以当前点(出栈)的高度计算的。
     * @param heights
     * @return
     */
    public static int largestRectangleArea(int[] heights) {
        if (heights.length == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < heights.length; i++){
            while (stack.peek() != -1 && heights[stack.peek()] > heights[i]){
                max = Math.max(max, heights[stack.pop()]*(i - stack.peek() -1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1){
            max = Math.max(max, heights[stack.pop()]*(heights.length - stack.peek() - 1));
        }
        return max;
    }

    public static int largestRectangleAreaTimes2(int[] heights) {
        if (heights.length == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack();
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0; i< heights.length; i++){
            while (stack.peek() != -1 && heights[stack.peek()] > heights[i]){
//                int index = stack.pop();
//                maxArea = Math.max(maxArea, heights[index]*(i - index));
                maxArea = Math.max(maxArea, heights[stack.pop()]*(i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while(stack.peek() != -1){
            maxArea = Math.max(maxArea, heights[stack.pop()]*(heights.length - stack.peek() - 1));
        }
        return maxArea;
    }
}
