package algorithms.other;


import java.util.Stack;

/**
 * Created by yangyuan on 2020/2/28.
 * 456. 132模式
 *
 * 给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < aj。设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。

 注意：n 的值小于15000。

 */
public class Find132pattern {
    public static void main(String[] args) {
        int[] data = {2,4,3,1};
        System.out.println(find132pattern(data));
    }

    /**
     * 单调栈
     * 从后往前遍历
     * 栈存放递增的序列， ak存放次大数
     * 为什么要从后往前遍历？？ 因为这样只需要新元素小于之前的两个就行了。。。
     * @param nums
     * @return
     */
    public static boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack();
        int ak = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--){
            if (nums[i] < ak){
                return true;
            }
            while (!stack.isEmpty() && stack.peek() < nums[i]){
                //这个max可以不用，ak 保证单调递增的。
                ak = stack.pop();//Math.max(ak, stack.pop());
            }
            stack.push(nums[i]);
        }
        return false;
    }

    // 231 模式则可以从前往后遍历了
    public static boolean find132pattern2(int[] nums) {
        return  false;
    }
}
