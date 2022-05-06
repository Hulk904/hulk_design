package algorithms.other.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yangyuan on 2021/6/5.
 * 893. 特殊等价字符串组
 * 你将得到一个字符串数组 A。

 每次移动都可以交换 S 的任意两个偶数下标的字符或任意两个奇数下标的字符。

 如果经过任意次数的移动，S == T，那么两个字符串 S 和 T 是 特殊等价 的。

 例如，S = "zzxy" 和 T = "xyzz" 是一对特殊等价字符串，因为可以先交换 S[0] 和 S[2]，然后交换 S[1] 和 S[3]，使得 "zzxy" -> "xzzy" -> "xyzz" 。

 现在规定，A 的 一组特殊等价字符串 就是 A 的一个同时满足下述条件的非空子集：

 该组中的每一对字符串都是 特殊等价 的
 该组字符串已经涵盖了该类别中的所有特殊等价字符串，容量达到理论上的最大值（也就是说，如果一个字符串不在该组中，那么这个字符串就 不会 与该组内任何字符串特殊等价）
 返回 A 中特殊等价字符串组的数量。

 */
public class NumSpecialEquivGroups {

    public int numSpecialEquivGroups(String[] words) {
        Set<String> set = new HashSet();
        for (String s:words){
            int[] count = new int[52];
            //相当于对奇数位和偶数位的元素分别计数、排序
            for (int i = 0; i < s.length(); i++){
                count[s.charAt(i) - 'a' + 26*(i%2)]++;
            }
            set.add(Arrays.toString(count));
        }
        return set.size();
    }
}
