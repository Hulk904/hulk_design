package algorithms.other.array;

/**
 * Created by yangyuan on 2020/11/28.
 * 565. 数组嵌套
 *
 * 索引从0开始长度为N的数组A，包含0到N - 1的所有整数。找到最大的集合S并返回其大小，
 * 其中 S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }且遵守以下的规则。

 假设选择索引为i的元素A[i]为S的第一个元素，S的下一个元素应该是A[A[i]]，之后是A[A[A[i]]]...
 以此类推，不断添加直到S出现重复的元素。

 */
public class ArrayNesting {

    //经典图论 每个元素看成一个点  就是多个环  相当于问哪个环最大
    // 遍历数组， 元素访问过就设置为-1 （标识下）
    public int arrayNesting(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != -1){
                int j = i, s = 0;
                while (nums[j] != -1){
                    s++;
                    int next = nums[j];
                    nums[j] = -1;
                    j = next;
                }
                res = Math.max(res, s);
            }
        }
        return res;
    }
}
