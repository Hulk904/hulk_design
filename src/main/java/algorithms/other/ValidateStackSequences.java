package algorithms.other;

import java.util.Stack;

/**
 * Created by yangyuan on 2020/4/15.
 */
public class ValidateStackSequences {

    /**
     * 思路很简单，我们尝试按照 popped 中的顺序模拟一下出栈操作，如果符合则返回 true，否则返回 false。
     * 这里用到的贪心法则是如果栈顶元素等于 popped 序列中下一个要 pop 的值，则应立刻将该值 pop 出来。
     我们使用一个栈 st 来模拟该操作。将 pushed 数组中的每个数依次入栈，同时判断这个数是不是 popped
     数组中下一个要 pop 的值，如果是就把它 pop 出来。最后检查栈是否为空。
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for (int i = 0; i < pushed.length; i++){
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[popIndex]){
                stack.pop();
                popIndex++;
            }
        }
        return popIndex == popped.length;
    }
}
