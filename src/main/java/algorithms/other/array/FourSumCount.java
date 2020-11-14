package algorithms.other.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangyuan on 2020/10/31.
 *
 * 454. 四数相加 II
 *
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。

 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。

 *
 */
public class FourSumCount {

    /**
     * 根据返回时间复杂度n^3就超时了。所以只能n^2或者n^2logn 了。 A+B+C+D  == 0   ==> A + B = -(C +D).
     * 先预处理 C+D 放在hashnap中，然后再遍历A、B
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap();
        for (int i:C){
            for (int j:D){
                map.put(i + j, map.getOrDefault(i + j, 0) + 1);
            }
        }
        int res = 0;
        for (int i:A){
            for (int j:B){
                res += map.getOrDefault(-1*(i + j), 0);
            }
        }
        return res;
    }
}
