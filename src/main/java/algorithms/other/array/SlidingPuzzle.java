package algorithms.other.array;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by yangyuan on 2021/4/4.
 * 773. 滑动谜题
 *
 * 在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示.

 一次移动定义为选择 0 与一个相邻的数字（上下左右）进行交换.

 最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。

 给出一个谜板的初始状态，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。

 */
public class SlidingPuzzle {

    public static void main(String[] args) {
        SlidingPuzzle slidingPuzzle = new SlidingPuzzle();
        int[][] board = new int[][]{{1,2,3}, {4,0,5}};
        slidingPuzzle.slidingPuzzle(board);
    }
    public int slidingPuzzle(int[][] board) {
        int [][] target = new int[][]{{1,2,3},{4,5,0}};
        if (changeToStr(board).equals(changeToStr(target))) return 0;
        Queue<int[][]> q = new LinkedList<>();
        q.add(board);
        Map<String, Integer> dist = new HashMap<>();
        dist.put(changeToStr(board), 0);
        int direc[][] = new int[][]{{1,0},{-1, 0},{0, 1},{0, -1}};
        while (!q.isEmpty()){
            int[][] t = q.poll();
            int x = 0, y = 0;//'0' 的位置
            for (int i = 0; i < 2; i++){
                for (int j = 0; j < 3; j++){
                    if (t[i][j] == 0){
                        x = i; y = j;
                    }
                }
            }
            for (int i = 0 ; i < 4; i++){
                int a = x + direc[i][0];
                int b = y + direc[i][1];
                if (a >= 0 && a < 2 && b >= 0 && b < 3){
                    int[][] r = copy(t);//二维数组的clone 方法，只能拷贝一层
                    int temp = r[x][y];
                    r[x][y] = r[a][b];
                    r[a][b] = temp;
                    if (dist.getOrDefault(changeToStr(r), 0) == 0){
                        dist.put(changeToStr(r), dist.getOrDefault(changeToStr(t), 0) + 1);
                        if (changeToStr(r).equals(changeToStr(target))) return dist.get(changeToStr(r));
                        q.add(r);
                    }
                }
            }
        }
        return -1;
    }

    int[][] copy (int[][] target){
        int[][] b = new int[target.length][target[0].length];
        for (int i = 0; i < target.length; i++){
            for (int j = 0; j < target[0].length; j++){
                b[i][j] = target[i][j];
            }
        }
        return b;
    }

    String changeToStr(int[][] board){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                sb.append(board[i][j]);
            }
        }
        return sb.toString();
    }

}





































