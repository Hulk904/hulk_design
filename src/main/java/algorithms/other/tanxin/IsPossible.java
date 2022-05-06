package algorithms.other.tanxin;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangyuan on 2021/2/28.
 * 659. 分割数组为连续子序列
 * 给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个长度至少为 3 的子序列，其中每个子序列都由连续整数组成。

 如果可以完成上述分割，则返回 true ；否则，返回 false 。

 */
public class IsPossible {
    //如果x可以接到一个数组后面则接到数组后面   贪心题
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> map1 = new HashMap();//记录每个元素的个数 （未使用的）
        Map<Integer, Integer> map2 = new HashMap();//记录以某一元素结尾的
        for (int i:nums){
            map1.put(i, map1.getOrDefault(i, 0) + 1);
        }
        for (int x:nums){
            if (map1.getOrDefault(x, 0) == 0) continue;
            if (map2.getOrDefault(x - 1, 0) > 0){//存在可以连续的子序列
                map2.put(x - 1, map2.getOrDefault(x - 1, 0) - 1);
                map2.put(x, map2.getOrDefault(x, 0) + 1);
                map1.put(x, map1.getOrDefault(x, 0) - 1);
            } else if (map1.getOrDefault(x + 1, 0) > 0 && map1.getOrDefault(x + 2, 0) > 0){ //新建一个子序列
                map2.put(x + 2, map2.getOrDefault(x + 2, 0) + 1);
                map1.put(x, map1.getOrDefault(x, 0) - 1);
                map1.put(x + 1, map1.getOrDefault(x + 1, 0) - 1);
                map1.put(x + 2, map1.getOrDefault(x + 2, 0) - 1);
            } else {
                return false;
            }
        }
        return true;
    }
}
