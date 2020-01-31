package algorithms.top100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by yangyuan on 2020/1/17.
 */
public class FindDisappearedNumbers {

    public static void main(String[] args) {
        int[] data = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers2(data));
    }

    /**
     * 如果数据存在，则设置这个数字代表索引的地方累加数组长度 （当前位置的数据也不会被覆盖）
     * 然后再次遍历，元素值小于数组长度的表示未出现过
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length == 1){
            return Collections.EMPTY_LIST;
        }
        for (int i = 0; i < nums.length; i++){
            int index = (nums[i] - 1)%nums.length;//注意
            nums[index] += nums.length;//注意 这里不会覆盖nums[index]处的值，上面 %length的时候可以获取出来
        }
        List<Integer> result = new ArrayList<>();
        for (int i =0; i < nums.length; i++){
            if (nums[i] <= nums.length){
                result.add(i + 1);
            }
        }
        return result;
    }

    /**
     * 抽屉原理 + 异或运算
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers2(int[] nums){

        for (int i = 0; i < nums.length; i++){
            while (nums[i] != nums[nums[i] - 1]){
                swap(nums, i, nums[i] - 1);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            if ((i + 1) != nums[i]){
                result.add(i + 1);
            }
        }
        return result;
    }

    /**
     * 异或运算交换两个变量的值（不使用辅助空间、变量为整数类型）
     *
     * 《linux多线程服务端编程》501页分析了，

     用异或运算交换变量，

     是错误的行为。

     并且不能加快运算，

     也不能节省内存

     re：多谢您的留言，我已经把补充部分的内容去掉了。这个技巧确实很鸡肋。

     https://leetcode-cn.com/problems/first-missing-positive/solution/tong-pai-xu-python-dai-ma-by-liweiwei1419/
     * @param nums
     * @param indexA
     * @param indexB
     */
    private static void swap (int[] nums, int indexA, int indexB){
        nums[indexA] = nums[indexA]^nums[indexB];
        nums[indexB] = nums[indexA]^nums[indexB];
        nums[indexA] = nums[indexA]^nums[indexB];
    }
}
