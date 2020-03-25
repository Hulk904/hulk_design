package algorithms.toutiao;

import com.alibaba.fastjson.JSON;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by yangyuan on 2020/1/29.
 * 239. 滑动窗口最大值
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

 返回滑动窗口中的最大值。

 单调队列处理

 */
public class MaxSlidingWindow {

    public static void main(String[] args) {
        int[] data = {1,3,-1,-3,5,3,6,7};
        System.out.println(JSON.toJSONString(maxSlidingWindow2(data, 3)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0){
            return new int[]{};
        }
        //维护递减的队列
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < k -1; i++){
            setQueue(queue, nums, i, k);
            queue.add(i);
        }
        int[] result = new int[nums.length - k + 1];
        for (int i = k - 1; i < nums.length; i++){
            setQueue(queue, nums, i, k);
            queue.add(i);
            result[i - k + 1] = nums[queue.getFirst()];
        }
        return result;
    }

    public static void setQueue (ArrayDeque<Integer> queue, int[] nums, int i, int k){
        if (!queue.isEmpty() && queue.getFirst() == i -k){
            queue.removeFirst();
        }
        while (!queue.isEmpty() && nums[queue.getLast()] < nums[i]){
            queue.removeLast();
        }
    }


    static int[] maxSlidingWindow2(int[] nums, int k){
        if (nums.length == 0){
            return new int[0];
        }
        int[] t = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++){
            //出队的可能是最大元素
            if (!deque.isEmpty() && i - deque.getFirst() + 1 > k ) deque.pollFirst();
            //维护为单调递减队列
            while (deque.size() > 0 && nums[deque.peekLast()] < nums[i]) deque.removeLast();
            deque.addLast(i);
            //
            if (i >= k - 1) t[i - k + 1] = nums[deque.peekFirst()];
        }
        return t;
    }


}
