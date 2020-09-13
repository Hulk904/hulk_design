package algorithms.other;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by yangyuan on 2020/6/7.
 * 1465. 切割后面积最大的蛋糕
 * 矩形蛋糕的高度为 h 且宽度为 w，给你两个整数数组 horizontalCuts 和 verticalCuts，其中 horizontalCuts[i]
 * 是从矩形蛋糕顶部到第  i 个水平切口的距离，类似地， verticalCuts[j] 是从矩形蛋糕的左侧到第 j 个竖直切口的距离。

 请你按数组 horizontalCuts 和 verticalCuts 中提供的水平和竖直位置切割后，请你找出 面积最大 的那份蛋糕，
 并返回其 面积 。由于答案可能是一个很大的数字，因此需要将结果对 10^9 + 7 取余后返回
 */
public class MaxArea {

    public static void main(String[] args) {
        int temp = 109866  *  125201;
        System.out.println(temp%1000000007);
        System.out.println(870431178 - 755332975);
    }

    public int maxArea(int h, int w, int[] hs, int[] vs) {
        Arrays.sort(hs);
        long maxHs = hs[0];
        for (int i = 1; i < hs.length; i++){
            maxHs = Math.max(maxHs, hs[i] - hs[i - 1]);
        }
        maxHs = Math.max(maxHs, h - hs[hs.length - 1]);
        Arrays.sort(vs);
        long maxVs = vs[0];
        for (int i = 1; i < vs.length; i++){
            maxVs = Math.max(maxVs, vs[i] - vs[i - 1]);
        }
        maxVs = Math.max(maxVs, w - vs[vs.length - 1]);
        long res = maxHs*maxVs;
        //开始在leetcode上一直提交报错 是因为写成了 (int)res %1000000007
        //操作符优先级的问题。。。
        return (int)(res %1000000007);
    }
}
