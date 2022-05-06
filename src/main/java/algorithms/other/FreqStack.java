package algorithms.other;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by yangyuan on 2021/6/5.
 * 895. 最大频率栈
 * 实现 FreqStack，模拟类似栈的数据结构的操作的一个类。

 FreqStack 有两个函数：

 push(int x)，将整数 x 推入栈中。
 pop()，它移除并返回栈中出现最频繁的元素。
 如果最频繁的元素不只一个，则移除并返回最接近栈顶的元素。

 */
public class FreqStack {

    Map<Integer, Stack<Integer>> stack;//
    Map<Integer, Integer> cnt;//所有元素出现次数
    int n = 0; //当前最大值

    public FreqStack() {
        cnt = new HashMap();
        stack = new HashMap();
    }

    public void push(int val) {
        int newCount = cnt.getOrDefault(val, 0) + 1;
        cnt.put(val, newCount);
        if (stack.get(newCount) == null){
            stack.put(newCount, new Stack<>());
        }
        stack.get(newCount).push(val);
        n = Math.max(n, cnt.get(val));
    }

    public int pop() {
        int t = stack.get(n).pop();
        cnt.put(t, cnt.getOrDefault(t, 0) - 1);
        if (stack.get(n).isEmpty()) n--;
        return t;
    }
}
