package algorithms.other.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by yangyuan on 2021/4/4.
 * 768. 最多能完成排序的块 II
 *
 * 这个问题和“最多能完成排序的块”相似，但给定数组中的元素可以重复，输入数组最大长度为2000，
 * 其中的元素最大为10**8。

 arr是一个可能包含重复元素的整数数组，我们将这个数组分割成几个“块”，并将这些块分别进行排序。
 之后再连接起来，使得连接的结果和按升序排序后的原数组相同。

 我们最多能将数组分成多少块？

 */
public class MaxChunksToSorted {
    /**
     * 贪心题
     * @param arr
     * @return
     */
    public int maxChunksToSorted(int[] arr) {
        int[] b = Arrays.copyOf(arr, arr.length);
        Arrays.sort(b);
        Map<Integer, Integer> cnt = new HashMap<>();
        int res = 0;
        for (int i = 0, s = 0; i < arr.length;i++){//s 非零元素数
            if (cnt.getOrDefault(arr[i], 0) == 1) s--;
            else if (cnt.getOrDefault(arr[i], 0) == 0) s++;
            cnt.put(arr[i], cnt.getOrDefault(arr[i], 0) - 1);
            if (cnt.getOrDefault(b[i], 0) == -1) s--;
            else if (cnt.getOrDefault(b[i], 0) == 0) s++;
            cnt.put(b[i], cnt.getOrDefault(b[i], 0) + 1);
            if (s == 0)res ++;
        }
        return res;
    }

    //leet code 经典解答
    public int maxChunksToSorted2(int[] arr) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        for(int num : arr) {
            if(!stack.isEmpty() && num < stack.getLast()) {
                int head = stack.removeLast();
                while(!stack.isEmpty() && num < stack.getLast()) stack.removeLast();
                stack.addLast(head);
            }
            else stack.addLast(num);
        }
        return stack.size();
    }
}
