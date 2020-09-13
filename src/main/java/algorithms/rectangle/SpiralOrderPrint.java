package algorithms.rectangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyuan on 2020/1/29.
 */
public class SpiralOrderPrint {
    public static void main(String[] args) {
        int[][] data = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        spiralOrderPrint(data);

    }

    public static void spiralOrderPrint(int[][] data){
        int tr = 0;
        int tc = 0;
        int dr = data.length - 1;
        int dc = data[0].length - 1;
        while (tr <= dr && tc <= dc){
            printCirlcle(data, tr++, tc++, dr--, dc--);
        }
    }

    private static void printCirlcle(int[][] data, int tr, int tc, int dr, int dc){
        if (tr == dr){
            for (int i = tc ; i <= dc; i++){
                System.out.print(data[tr][i] + " ");
            }
            return;
        }
        if (tc == dc){
            for (int i = tr; i <= dr; i++){
                System.out.print(data[i][tc]+ " ");
            }
            return;
        }
        int m = tr;
        int n = tc;
        while ( n < dc){//留下最后一个元素给下次打印 。不然处理会比较混乱了
            System.out.print(data[tr][n++]+ " ");
        }
        while (m < dr){
            System.out.print(data[m++][dc]+ " ");
        }
        while (n > tc){
            System.out.print(data[dr][n--]+ " ");
        }
        while (m > tr){
            System.out.print(data[m--][tc]+ " ");
        }
    }

    public List<Integer> spiralOrderNew(int[][] matrix) {
        List<Integer> res = new ArrayList();
        int n = matrix.length;
        int m = matrix[0].length;
        int dx[] = {0, 1, 0, -1};
        int dy[] = {1, 0, -1, 0};
        boolean[][] st = new boolean[n][m];
        for (int i = 0 ,x = 0, y = 0 , d = 0; i < n*m; i++){
            res.add(matrix[x][y]);
            st[x][y]= true;
            int a = x + dx[d], b= y + dy[d];
            if (a < 0 || a >= n || b < 0 || b >= m || st[a][b]){
                d = (d + 1)%4;
                a = x + dx[d];
                b= y + dy[d];
            }
            x = a;
            y = b;
        }
        return res;
    }
}
