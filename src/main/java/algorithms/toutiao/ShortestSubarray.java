package algorithms.toutiao;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by yangyuan on 2020/2/22.
 * 862
 *
 * 返回 A 的最短的非空连续子数组的长度，该子数组的和至少为 K 。

 如果没有和至少为 K 的非空子数组，返回 -1 。
 */
public class ShortestSubarray {

    public static void main(String[] args) {
        int[] data = {1};
        shortestSubarray(data, 1);
    }

    public static  int shortestSubarray(int[] A, int K) {

        int[] cum = new int[A.length + 1];
        for (int i = 0; i < A.length; i++){
            cum[i + 1] = cum[i] + A[i];
        }
        int result = A.length + 1;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < cum.length; i++){
            //两个while呢
            //比前面元素小，然后还在它后面，所以前面的元素不可能被选上，所以pop出来
            while (!deque.isEmpty() && cum[deque.getLast()] > cum[i]){//递增的队列
                deque.removeLast();
            }
            while (!deque.isEmpty() && cum[i] >= cum[deque.getFirst()] + K){
                result = Math.min(result, i - deque.removeFirst());//如果当前元素满足，需要
            }
            deque.addLast(i);
        }
        return result == A.length + 1 ? -1 : result;


    }
}
