package algorithms;

import java.util.Stack;

/**
 * Created by yangyuan on 2019/3/11.
 */
public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        reverse(stack);
    }

    /**
     * 这个方法只是逆序输出了但是并没有逆序栈中的数据
     * @param stack
     */
    public static void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int s = stack.pop();
        reverse(stack);
        System.out.println(s);
    }


}
