package algorithms.top100;

/**
 * Created by yangyuan on 2020/1/3.
 *
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。

 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

思路：遍历所有的元素 +  深度优先 & 回溯   和在腾讯面试的时候 岛数量类似。
 */
public class StringExist {

    public static void main(String[] args) {
        //char[][] data = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        char[][] data = {{'a','a'}};
        System.out.println(exist(data, "aaa"));
    }



    public static boolean exist(char[][] board, String word) {

        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j< board[0].length; j++){
                if (dps(board, visited, i, j, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    public static  boolean dps(char[][] board, boolean[][] visited, int i ,int j ,String word, int current){
        if(!inArea( board.length, board[0].length, i, j)){
            return false;
        }
        if (visited[i][j]){//注意别漏掉了。。。
            return false;
        }
        if (current == word.length() - 1){
            //不能写成 下面这样 （在方法的最开始判断）， 不然像 [[a]], word = a 的用例过不了。因为后面的迭代是下一次元素的判断
//            if (current == word.length()){
//                return true;
//            }
            return board[i][j] == word.charAt(current) ;
        }
        if (board[i][j] == word.charAt(current++)) {
            visited[i][j] = true;
            if( dps(board, visited, i-1, j, word, current) ||
                    dps(board, visited, i + 1, j, word, current)||
                    dps(board, visited, i, j + 1, word, current)||
                    dps(board, visited, i ,j - 1, word, current)){
                return true;
            }
            visited[i][j] = false;
        }
        return false;
    }

    private static boolean inArea(int width, int height, int i ,int j){
        if (0 <= i && i < width && 0<=j && j < height){
            return true;
        }
        return false;
    }

}
