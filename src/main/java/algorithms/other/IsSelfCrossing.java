package algorithms.other;

/**
 * Created by yangyuan on 2020/9/19.
 * 335. 路径交叉
 *
 * 给定一个含有 n 个正数的数组 x。从点 (0,0) 开始，先向北移动 x[0] 米，然后向西移动 x[1] 米，向南移动 x[2] 米，向东移动 x[3] 米，持续移动。也就是说，每次移动后你的方位会发生逆时针变化。

 编写一个 O(1) 空间复杂度的一趟扫描算法，判断你所经过的路径是否相交。

 贪心实现
 */
public class IsSelfCrossing {
    public boolean isSelfCrossing(int[] x) {
        int n = x.length;
        if (n <= 3) return false;
        for (int i = 3; i < n; i++){
            if (x[i - 1] <= x[i - 3] && (x[i] >= x[i - 2])) return true;
            if (i >= 4 && (x[i - 3] == x[i - 1]) && (x[i] + x[i - 4] >= x[i - 2])) return true;
            if (i >= 5 && (x[i - 3] >= x[i - 1]) && (x[i - 1] + x[i - 5] >= x[i - 3]) && (x[i - 2] >= x[i - 4]) && (x[i - 4] + x[i] >= x[i - 2])) return true;
        }
        return false;
    }
}
