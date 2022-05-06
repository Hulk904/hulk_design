package algorithms.other.array;

/**
 * Created by yangyuan on 2021/3/21.
 *
 * 733. 图像渲染
 *
 * 有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。

 给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。

 为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。

 最后返回经过上色渲染后的图像。

 */
public class FloodFill {

    int[][] g ;
    int [][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1},{0, 1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        g = image;
        int color = g[sr][sc];
        if (color == newColor) return g;
        dfs(sr, sc, color, newColor);
        return g;
    }

    void dfs(int sr, int sc, int color, int newColor){
        g[sr][sc] = newColor;
        for (int i = 0; i < direction.length; i++){
            int x = sr + direction[i][0];
            int y = sc + direction[i][1];
            if (x >=0 && x < g.length && y >= 0 && y < g[0].length && g[x][y] == color){
                dfs(x, y, color, newColor);
            }
        }
    }
}
