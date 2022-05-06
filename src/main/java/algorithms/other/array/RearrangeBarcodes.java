package algorithms.other.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangyuan on 2021/12/20.
 * 1054. 距离相等的条形码
 * 在一个仓库里，有一排条形码，其中第 i 个条形码为 barcodes[i]。

 请你重新排列这些条形码，使其中两个相邻的条形码 不能 相等。 你可以返回任何满足该要求的答案，此题保证存在答案。


 */
public class RearrangeBarcodes {

    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i:barcodes){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int[][] q = new int[map.size()][2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry:map.entrySet()){
            q[i++] = new int[]{entry.getValue(), entry.getKey()};
        }
        Arrays.sort(q, (a, b)-> b[0] - a[0]);
        int k = 0;
        for (int[] t:q){
            while (t[0]-- > 0){
                barcodes[k] = t[1];
                k+=2;
                if (k >= barcodes.length) k = 1;
            }
        }
        return  barcodes;
    }
}
