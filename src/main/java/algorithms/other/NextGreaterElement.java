package algorithms.other;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by yangyuan on 2020/2/27.
 * 496. 下一个更大元素 I
 * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。

 nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。

 */
public class NextGreaterElement {

    public static void main(String[] args) {
        int[] num1 = {4,1,2};
        int[] num2 = {1,3,4,2};
        System.out.println(nextGreaterElement(num1, num2));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = nums2.length - 1; i >=0; i--){
            while (!stack.isEmpty() && stack.peek() < nums2[i]) stack.pop();
            map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++){
            result[i] = map.get(nums1[i]);
        }
        return result;
    }

}
