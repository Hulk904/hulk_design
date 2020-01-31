package algorithms.top100;

import java.util.Stack;

/**
 * Created by yangyuan on 2020/1/9.
 */
public class MinStack {

    private Stack<Integer> element;

    private Stack<Integer> helpStack;

    public MinStack() {
        element = new Stack<>();
        helpStack = new Stack<>();
    }

    public void push(int x) {
        if(helpStack.isEmpty()){
            helpStack.push(x);
            element.push(x);
            return;
        }
        if (x <= helpStack.peek()){
            helpStack.push(x);
            element.push(x);
            return;
        }
        element.push(x);
    }

    public void pop() {
        int data = element.pop();
        if (data == helpStack.peek()){
            helpStack.pop();
        }
    }

    public int top() {
        return element.peek();
    }

    public int getMin() {
        return helpStack.peek();
    }

}
