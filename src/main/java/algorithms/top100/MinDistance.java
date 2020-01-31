package algorithms.top100;

/**
 * Created by yangyuan on 2020/1/8.
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。

 你可以对一个单词进行如下三种操作：

 插入一个字符
 删除一个字符
 替换一个字符

 */
public class MinDistance {

    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";
        System.out.println(minDistance(s1, s2));
    }

    public static int minDistance(String word1, String word2) {
        int[][] data = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++){
            data[i][0] = i;
        }
        for (int j = 0; j <= word2.length(); j++){
            data[0][j] = j;
        }
        for (int i = 1; i <= word1.length(); i++){
            for (int j = 1; j <= word2.length(); j++){
                int a = data[i][j - 1] + 1;
                int b = data[i - 1][j] + 1;
                int c = data[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)){
                    c ++;
                }
                data[i][j] = Math.min(a, b);
                data[i][j] = Math.min(data[i][j], c);
            }
        }
        return data[word1.length()][word2.length()];
    }
}
