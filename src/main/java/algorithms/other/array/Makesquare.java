package algorithms.other.array;

import java.util.Arrays;

/**
 * Created by yangyuan on 2020/11/7.
 *
 * 473. 火柴拼正方形
 *
 * 还记得童话《卖火柴的小女孩》吗？现在，你知道小女孩有多少根火柴，请找出一种能使用所有火柴拼成一个正方形的方法。不能折断火柴，可以把火柴连接起来，并且每根火柴都要用到。

 输入为小女孩拥有火柴的数目，每根火柴用其长度表示。输出即为是否能用所有的火柴拼成正方形。

 */
public class Makesquare {

    //dfs 剪枝的经典
    //剪枝
    //1、从大到小枚举
    //2、每条边内部，要求火柴比编好递增
    //3、若当前放某根火柴失败
    //      3.1 跳过长度相同的火柴
    //      3.2 是第一根火柴，则剪枝当前分支
    //      3.3 是最后一根，也剪掉当前分支

    int[] nums;
    boolean[] st ;
    public boolean makesquare(int[] nums) {
        if (nums.length == 0) return false;
        this.nums = nums;
        st = new boolean[nums.length];
        int sum = 0;
        for (int i:nums) sum += i;
        if (sum%4 != 0) return false;
        sum /= 4;
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        while (l < r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;r--;
        }
        return dfs(0, 0, sum , 0);
    }

    boolean dfs(int start, int cur, int length, int cnt){
        if (cnt ==3) return true;
        if (cur == length) return dfs(0, 0, length, cnt + 1);
        for (int i = start; i < nums.length; i++){
            if (st[i]) continue;//已使用
            if (cur + nums[i] <= length){
                st[i] = true;
                if (dfs(i + 1, cur + nums[i], length, cnt)) return true;
                st[i] = false;
            }
            if (cur == 0 || cur + nums[i] == length ) return false;
            while (i + 1 < nums.length && nums[i + 1] == nums[i]){
                i++;
            }
        }
        return false;
    }
}
