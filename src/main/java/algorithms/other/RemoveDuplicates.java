package algorithms.other;

/**
 * Created by yangyuan on 2020/4/19.
 * 80. 删除排序数组中的重复项 II
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，
 * 返回移除后数组的新长度。
 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成

 */
public class RemoveDuplicates {
    /**
     * 思路不难，但是写出这么简洁的代码真的好难。
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        // Initialize the counter and the second pointer.
        int j = 1, count = 1;
        // Start from the second element of the array and process
        // elements one by one.
        for (int i = 1; i < nums.length; i++) {
            // If the current element is a duplicate, increment the count.
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                // Reset the count since we encountered a different element
                // than the previous one.
                count = 1;
            }
            // For a count <= 2, we copy the element over thus
            // overwriting the element at index "j" in the array
            if (count <= 2) {// 小于2才会向前复制数据。 大于2时什么不用做，i 往后++就行。。
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    public static void main(String[] args) {
        RemoveDuplicates r = new RemoveDuplicates();
        int[] data = {1,1,1,2,2,3};
        r.removeDuplicates2(data);
    }

    /**
     * 这个思路也很惊奇
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int sp = 1;//有效数字的下标
        for (int fp = 2; fp < nums.length; fp++){//fp 当前已扫描的元素
            if (nums[sp -1] != nums[fp]){
                nums[++sp] = nums[fp];
            }
        }
        return sp + 1;
    }

}
