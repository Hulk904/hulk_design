package algorithms.toutiao;

import com.alibaba.fastjson.JSON;

import java.util.ArrayDeque;

/**
 * Created by yangyuan on 2020/1/29.
 */
public class MaxSlidingWindow {

    public static void main(String[] args) {
        int[] data = {1,3,-1,-3,5,3,6,7};
        System.out.println(JSON.toJSONString(maxSlidingWindow(data, 3)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0){
            return new int[]{};
        }
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
}
