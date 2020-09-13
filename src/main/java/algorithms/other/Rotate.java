package algorithms.other;

import java.util.Arrays;

/**
 * Created by yangyuan on 2020/4/21.
 * 189. 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 */
public class Rotate {

    /**
     * 环状替代和我的思路一致，不过我觉得这样解释可能更容易理解。把元素看做同学，
     * 把下标看做座位，大家换座位。第一个同学离开座位去第k+1个座位，第k+1个座位的同学被挤出去了，
     * 他就去坐他后k个座位，如此反复。但是会出现一种情况，就是其中一个同学被挤开之后，
     * 坐到了第一个同学的位置（空位置，没人被挤出来），但是此时还有人没有调换位置，这样就顺着让第二个同学换位置。
     * 那么什么时候就可以保证每个同学都换完了呢？n个同学，换n次，所以用一个count来计数即可
     *
     * 关键怎么理解在单次循环替换中，通过一个中间变量就可以完成。。。
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++){
            int cur = start;
            int pre = nums[cur];
            do {
                int next = (cur + k)%nums.length;
                int temp = nums[next];
                nums[next] = pre;
                pre = temp;
                cur = next;
                count++;
            } while (cur != start);
        }
    }


    /**
     * 三次 翻转
     * 先翻转所有元素
     * 单独翻转前k个元素
     * 单独翻转剩余的元素
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        k = k%nums.length;
        rotate(nums, 0, nums.length - 1);
        rotate(nums, 0, k - 1);
        rotate(nums, k, nums.length - 1);
    }

    private void rotate(int[] nums, int begin, int end){
        while (begin < end){
            int temp = nums[end];
            nums[end] = nums[begin];
            nums[begin] = temp;
            begin++;
            end--;
        }
    }

}
