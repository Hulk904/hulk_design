package algorithms.search.bst;

/**
 * Created by yangyuan on 2018/8/27.
 * P46  在有序的二维数组中找到数据是否存在
 */
public class Find {

    public static void main(String[] args) {
        int [][] data = new int[][]{
            {1,2,8,9},
            {2,4,9,12},
            {4,7,10,13},
            {6,8,11,15}};
        System.out.println(findEle(data, 3));

    }

    private  static boolean findEle(int [][] arr, int b){
        int columns = arr[0].length;
        int rows = 0;// arr.length;
        while(columns >0 && rows < arr.length) {
            if (arr[rows][columns - 1] > b) {
                columns--;
                continue;
            }
            if (arr[rows][columns - 1] < b) {
                rows++;
                continue;
            }
            if (arr[rows][columns - 1] == b) {
                return true;
            }
        }
        return false;
    }
}
