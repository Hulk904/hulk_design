package algorithms;

import java.util.Stack;

/**
 * Created by yangyuan on 2018/8/31.
 * 使用两个栈来实现队列，关键是思路要简单清除。不要过于复杂
 * 让一个栈保证正常的输入顺序，一个用于临时倒置的，在使用时倒置回来
 * 在stack2中有数据时直接输出，直到为空才会从stack1中拉去数据，不能搞到一半就去拉数据了
 * 从心里上藐视它
 *
 * 使用两个队列实现一个栈时 ， 将一个队列中的元素都移动到
 * 另一个队列中，只留下最后一个就是要被删除的。
 */
public class TwoStackImplementQueue {

    public static void main(String[] args) {
        TwoStackImplementQueue t = new TwoStackImplementQueue();
        t.appendTail(3);
        t.appendTail(5);
        System.out.println(t.deleteHead());
        t.appendTail(6);
        t.appendTail(7);
        System.out.println(t.deleteHead());
        System.out.println(t.deleteHead());
        System.out.println(t.deleteHead());
    }

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    private void appendTail(Integer t){
        stack1.push(t);
    }

    private Integer deleteHead(){
        if(stack2.size() > 0){
            return stack2.pop();
        }
        if(stack2.size() <= 0){
            while(stack1.size() > 0) {
                Integer temp = stack1.pop();
                stack2.push(temp);
            }
        }
        if(stack2.size() == 0){
            new RuntimeException("empty.");
        }
        return stack2.pop();
    }
}
