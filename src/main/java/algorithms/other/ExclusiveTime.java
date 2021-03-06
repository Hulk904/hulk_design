package algorithms.other;

import java.util.List;
import java.util.Stack;

/**
 * Created by yangyuan on 2020/12/20.
 * 636. 函数的独占时间
 *给出一个非抢占单线程CPU的 n 个函数运行日志，找到函数的独占时间。

 每个函数都有一个唯一的 Id，从 0 到 n-1，函数可能会递归调用或者被其他函数调用。

 日志是具有以下格式的字符串：function_id：start_or_end：timestamp。例如："0:start:0" 表示函数 0 从 0 时刻开始运行。"0:end:0" 表示函数 0 在 0 时刻结束。

 函数的独占时间定义是在该方法中花费的时间，调用其他函数花费的时间不算该函数的独占时间。你需要根据函数的 Id 有序地返回每个函数的独占时间。

 */
public class ExclusiveTime {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> stack = new Stack();
        int last = 0;
        for (String log:logs){
            int x = log.indexOf(":");
            int y = log.lastIndexOf(":");
            int start = Integer.parseInt(log.substring(0, x));
            int end = Integer.parseInt(log.substring(y + 1));
            if (log.contains("start")){
                if (stack.size() > 0) res[stack.peek()] += end - last;// 前面还有元素，那么时间算在前面方法里面
                stack.push(start);
                last = end;
            } else {
                res[stack.pop()] += end - last + 1;
                last = end + 1;
            }
        }
        return res;
    }
}
