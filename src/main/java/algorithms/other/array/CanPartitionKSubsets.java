package algorithms.other.array;

import java.util.Arrays;

/**
 * Created by yangyuan on 2021/3/13.
 * 698. 划分为k个相等的子集
 *
 * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 *
 * 可以当作模版题，背过
 */
public class CanPartitionKSubsets {

    int len;
    int[] nums;
    boolean[] st;//每个数是否用过
    //四个剪枝   （没有这四个剪枝也能过）
    // 从大到小枚举
    // 把所有和当前相同的数跳过
    //当前是第一个数 无解
    //当前是最后一个数 无解

    public boolean canPartitionKSubsets(int[] nums, int k) {
        this.nums = nums;
        st = new boolean[nums.length];
        int sum =0;
        for (int i:nums) sum += i;
        if(sum%k != 0) return false;
        this.len = sum/k;
        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1; i < j; i++, j--){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return dfs(0, 0, k);
    }

    /**
     *
     * @param start  当前组从第几个开始搜
     * @param cur  当前组总和
     * @param k  已经搜了几组
     * @return
     */
    boolean dfs(int start, int cur, int k){
        if (k == 0) return true;
        if (cur == len) return dfs(0, 0 ,k - 1);//当前组和等于len，搜下一组
        for (int i = start; i < nums.length; i++){
            if (st[i]) continue;
            if (cur + nums[i] <= len){
                st[i] = true;
                if (dfs(i + 1, cur + nums[i], k)) return true;
                st[i] = false;
            }
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) i++;//当前无解，那么之后和他相等的也都没解
            if (cur == 0 || cur + nums[i] == len) return false;//当前第一个或者最后一个一定无解
        }
        return false;
    }
}
