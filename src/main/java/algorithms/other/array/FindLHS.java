package algorithms.other.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangyuan on 2020/12/6.
 *
 * 594. 最长和谐子序列
 *
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。

 现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。
 */
public class FindLHS {

    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for(int i:nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> e:map.entrySet()){
            if (map.get(e.getKey() - 1) != null){
                res = Math.max(res, e.getValue() + map.get(e.getKey() - 1));
            }
        }
        return res;
    }
}
