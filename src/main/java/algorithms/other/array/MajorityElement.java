package algorithms.other.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyuan on 2020/8/22.
 * 229. 求众数 II
 * 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。

 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。

 摩尔投票法 可以看leetcode 解答
  可以扩展到 求 n/k 的问题。。。
 */
public class MajorityElement {

    public static void main(String[] args) {
        MajorityElement m = new MajorityElement();
        int[] nums = new int[]{1,1,1,1,2,3,4,5,6,7,8,9};
        m.majorityElement(nums);
    }

    public List<Integer> majorityElement(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        int r1 = nums[0] , c1 = 0;
        int r2 = nums[0] , c2 = 0;
        for (int x:nums){//这里不是 if 关系。而是 else if 所以  每次都只走一个分支
            if (c1 > 0 && x == r1) c1++;
            else if (c2 > 0 && x == r2) c2++;
            else if (c1 == 0) {
                r1 = x;
                c1 = 1;
            } else if (c2 == 0){
                r2 = x;
                c2 = 1;
            } else {
                c1--;
                c2--;
            }
        }
        c1 = 0;
        c2 = 0;
        //r1,r2不一定是最后的结果，所以还需要校验下
        for (int x:nums){
            if (x == r1) c1++;
            else if (x == r2) c2++;//这里是 else if 。不然 [1] 用例将会计算错误。这时候  返回[1,1]
        }
        //可能存在两个元素
        List<Integer> res = new ArrayList<>();
        if (c1 > nums.length/3) res.add(r1);
        if (c2 > nums.length/3) res.add(r2);
        return res;
    }
}
