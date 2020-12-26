package algorithms.other.array;

import java.util.Arrays;

/**
 * Created by yangyuan on 2020/12/26.
 *
 * 646. 最长数对链
 *
 * 给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。

 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。

 给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。

 */
public class FindLongestChain {

    /**
     *  先按右端点升序排序，
     *  然后贪心选择，能选择选
     *
     *  证明：
     *  贪心解 >= 最优解
     *  贪心解 <= 最优解
     *
     *
     * @param pairs
     * @return
     */
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int res = 1;
        int max = pairs[0][1];
        for (int i = 1; i < pairs.length; i++){
            if (pairs[i][0] > max){
                res++;
                max = pairs[i][1];
            }
        }
        return res;
    }
}
