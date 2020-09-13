package algorithms.other.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yangyuan on 2020/9/13.
 * 315. 计算右侧小于当前元素的个数
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质：
 * counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。


 */
public class CountSmaller {

    int n = 20001;
    int[] tr = new int[n + 1];

    /**
     * 线段树的三个函数
     * @param x
     * @return
     */
    int lowbit(int x){
        return x &-x;
    }

    int query (int x){
        int res = 0;
        for (int i = x; i > 0; i -= lowbit(i)) res+=tr[i];
        return res;
    }
    //加上一个数
    void add(int x, int v){
        for (int i = x; i <= n; i += lowbit(i))tr[i]+=v;
    }

    public List<Integer> countSmaller(int[] nums) {
        Integer[] res = new Integer[nums.length];
        for (int i = nums.length - 1; i >= 0; i--){
            int x = nums[i] + 10001;
            res[i] = query(x - 1);
            add(x, 1);
        }
        return Arrays.asList(res);
    }
}
