package algorithms.other.array;

import java.util.TreeMap;

/**
 * Created by yangyuan on 2021/5/16.
 * 846. 一手顺子
 *
 * 爱丽丝有一手（hand）由整数数组给定的牌。 

 现在她想把牌重新排列成组，使得每个组的大小都是 W，且由 W 张连续的牌组成。

 如果她可以完成分组就返回 true，否则返回 false。

 */
public class IsNStraightHand {

    public boolean isNStraightHand(int[] hand, int W) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i:hand){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        while (map.size() > 0){
            int first = map.firstKey();
            for (int i = first; i < first + W; i++){
                if (!map.containsKey(i)) return false;
                int c = map.get(i);
                if (c == 1) map.remove(i);
                else {
                    map.put(i, c - 1);
                }
            }
        }
        return true;
    }
}
