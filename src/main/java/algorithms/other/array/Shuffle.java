package algorithms.other.array;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by yangyuan on 2020/10/2.
 * 384. 打乱数组
 *
 * 打乱一个没有重复元素的数组。
 */
public class Shuffle {

    int[] nums ;

    public Shuffle(int[] nums) {
        this.nums = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random r = new Random();
        int[] b = Arrays.copyOf(nums, nums.length);
        int n = nums.length;
        for (int i = 0; i < n; i++){
            int temp = b[i];
            int next = i + r.nextInt(n - i);
            b[i] = b[next];
            b[next] = temp;
        }
        return b;
    }
}
