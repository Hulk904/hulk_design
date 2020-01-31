package algorithms.top100;

import com.alibaba.fastjson.JSON;

/**
 * Created by yangyuan on 2020/1/2.
 *
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

 注意:
 不能使用代码库中的排序函数来解决这道题。

 思路弄清了，写代码还是容易的，关键是怎么弄
 刚开始以为快排的思路0的放左边，2的放右边，1丢掉不管，最后他们区间补1就行了。 这样其实也可以但是把流程弄复杂了。

 */
public class SortColors {
    public static void main(String[] args) {
        int[] a = {2,0,2,1,1,0};
        sortColors(a);
        System.out.println(JSON.toJSONString(a));
    }

    public static void sortColors(int[] nums){
        int p0 = 0, cur = 0,  p2 = nums.length -1;
        while (cur <= p2 ){
           if (nums[cur] == 0){
               swap(nums, p0, cur);
               cur++;//注意  刚开是漏掉了这个
               p0++;
           } else if (nums[cur] == 2){
               swap(nums, p2, cur);
               p2--;
           } else {
               cur++;//注意
           }
        }

    }

    private static void swap(int[] a, int i ,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
