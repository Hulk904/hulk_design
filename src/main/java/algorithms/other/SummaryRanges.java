package algorithms.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyuan on 2020/8/22.
 * 228. 汇总区间
 *
 * 给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList();
        for (int i = 0; i < nums.length; i++){
            int j = i + 1;
            while (j < nums.length && nums[j] == nums[j - 1] + 1) j++;
            if (j == i + 1) res.add("" + nums[i]);//只有一个数的情况
            else {
                res.add(nums[i] + "->" + nums[j-1]);
            }
            i = j - 1;
        }
        return res;
    }
}
