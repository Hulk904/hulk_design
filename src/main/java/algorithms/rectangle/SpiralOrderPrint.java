package algorithms.rectangle;

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
}
