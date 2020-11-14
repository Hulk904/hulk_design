package algorithms.other;

import java.util.Random;

/**
 * Created by yangyuan on 2020/11/14.
 * 497. 非重叠矩形中的随机点
 *
 * 给定一个非重叠轴对齐矩形的列表 rects，写一个函数 pick 随机均匀地选取矩形覆盖的空间中的整数点。
 */
public class Pick {
    /**
     * 先求出每个矩形的面积
     * 转化为一维的问题（在线段上，长度等于面积）
     * 然后分别随机长和宽
     * @param rects
     */

    int n;

    int[][] rects;

    int[] s;


    public Pick(int[][] rects) {
        this.rects = rects;
        n = rects.length;
        s = new int [n + 1];
        s[0] = 0;
        for (int i = 1 ;i <= n; i++){//前缀和， 转换为一维
            int dx = rects[i - 1][2] - rects[i - 1][0] + 1;//注意加1 a~b 一共有b-a + 1个数
            int dy = rects[i - 1][3]- rects[i - 1][1] + 1;
            s[i] = s[i - 1] + dx*dy;
        }
    }

    public int[] pick() {
        Random random = new Random();
        int k = random.nextInt(s[s.length - 1]) + 1;
        int l = 1, r = n;
        while (l < r){//二分查找确定在哪个区间
            int mid = l + r >> 1;
            if (s[mid] >= k) r = mid;
            else l = mid + 1;
        }
        int[] t = rects[r - 1];
        int dx = t[2] - t[0] + 1;
        int dy = t[3] - t[1] + 1;
        return new int[]{random.nextInt(dx) + t[0], random.nextInt(dy) + t[1]};
    }
}
