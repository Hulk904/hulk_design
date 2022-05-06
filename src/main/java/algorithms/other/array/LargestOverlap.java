package algorithms.other.array;

/**
 * Created by yangyuan on 2021/5/15.
 * 835. 图像重叠
 * 给你两个图像 img1 和 img2 ，两个图像的大小都是 n x n ，用大小相同的二维正方形矩阵表示。（并且为二进制矩阵，只包含若干 0 和若干 1 ）

 转换其中一个图像，向左，右，上，或下滑动任何数量的单位，并把它放在另一个图像的上面。之后，该转换的 重叠 是指两个图像都具有 1 的位置的数目。

 （请注意，转换 不包括 向任何方向旋转。）

 最大可能的重叠是多少？

 */
public class LargestOverlap {
    //相当于 img1 从-n 到n区间进行挪动， 计算出最大的重叠面积
    public int largestOverlap(int[][] img1, int[][] img2) {
        int res = 0;
        int n = img1.length;
        for (int i = -n; i < n; i++){
            for (int j = -n; j < n; j++){
                int cnt = 0;
                for (int x = Math.max(0, -i); x < Math.min(n, n - i); x++){
                    for (int y = Math.max(0, -j); y < Math.min(n, n - j); y++){
                        if (img1[i + x][j + y] == 1 && img2[x][y] == 1){
                            cnt ++;
                        }
                    }
                }
                res = Math.max(res, cnt);
            }
        }
        return res;
    }
}
