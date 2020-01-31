package algorithms.top100;

/**
 * Created by yangyuan on 2020/1/9.
 *
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。

这个在腾讯面试的时候写过，那时貌似给写出来了，都不知道当时咋写出来的，超常发挥啊。


 */
public class IslandNum {

    public static void main(String[] args) {
        char[][] data = {{'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}};
        System.out.println(numIslands(data));
    }

    public static int numIslands(char[][] grid) {

        int num = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1'){
                    num ++;
                    islandSearch(grid, i, j);
                }
            }
        }
        return num;
    }

    private static void islandSearch(char[][] grid, int i ,int j){
        if (i >= grid.length || i < 0) return;
        if (j >= grid[0].length || j < 0) return;
        if (grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        islandSearch(grid, i -1,j);
        islandSearch(grid, i + 1, j );
        islandSearch(grid, i , j - 1);
        islandSearch(grid, i , j + 1);

    }


}
