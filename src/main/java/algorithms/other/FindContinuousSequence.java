package algorithms.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyuan on 2020/4/18.
 * 面试题57 - II. 和为s的连续正数序列
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 */
public class FindContinuousSequence {


    public int[][] findContinuousSequence(int target) {
        List<int[]> result = new ArrayList<>();
        for (int i = 1, j = 1, curSum = 1; i <= target / 2; i++) {
            while (curSum < target) {
                curSum += ++j;  //具有单调性 j不回头
            }
            if (curSum == target && j - i > 0) {
                int[] list = new int[j - i + 1];
                for (int k = 0; k <= j - i; k++) {
                    list[k] = i + k;
                }
                result.add(list);
            }
            curSum -= i;
        }
        return result.toArray(new int[result.size()][]);
    }
}
