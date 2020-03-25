package algorithms.other;

/**
 * Created by yangyuan on 2020/3/24.
 * 面试题 08.10. 颜色填充
 * 颜色填充。编写函数，实现许多图片编辑软件都支持的“颜色填充”功能。给定一个屏幕
 * （以二维数组表示，元素为颜色值）、一个点和一个新的颜色值，将新颜色值填入这个点的周围区域，
 * 直到原来的颜色值全都改变。

 */
public class FloodFill {

    int[][] direction = {{-1, 0},{0, 1},{1, 0},{0, -1}};

    /**
     * 要理解题意先。 与目标颜色一样的相邻的点着色。 这里0不代表特殊含义
     * @param image
     * @param sr
     * @param sc
     * @param newColor
     * @return
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        dfs(image, sr, sc,image[sr][sc], newColor);
        return image;
    }

    void dfs(int[][] image, int sr, int sc, int originColor, int newColor){
        if (image[sr][sc] != originColor || image[sr][sc] == newColor) return;
        image[sr][sc] = newColor;
        for (int i = 0; i < direction.length; i++){
            int a = sr + direction[i][0];
            int b = sc + direction[i][1];
            if (!inbound(a, b, image.length, image[0].length)) continue;//注意不要写成 return了。for循环中的return要注意了
            dfs(image, a, b,originColor, newColor);
        }
    }

    boolean inbound(int a, int b, int i, int j){
        if (a >=0 && a < i && b >=0 && b < j) return true;
        return false;
    }
}
