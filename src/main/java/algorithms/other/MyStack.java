package algorithms.other;

import java.util.LinkedList;

/**
 * Created by yangyuan on 2020/4/21.
 * 225. 用队列实现栈
 *  这种方式应该不满足。 队列只能头出，尾进
 */
public class MyStack {

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
    }

    LinkedList<Integer> list;

    /** Initialize your data structure here. */
    public MyStack() {
        list = new LinkedList();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        list.addFirst(x);
        int size = list.size();
        while (size > 1){
            list.addFirst(list.removeLast());
            size--;
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (list.size() > 0){
            return list.removeLast();
        }
        return 0;
    }

    /** Get the top element. */
    public int top() {
        if (list.size() > 0){
            return list.peekLast();
        }
        return 0;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return list.size() == 0;
    }

}
