package algorithms.other.array;

/**
 * Created by yangyuan on 2020/10/25.
 * 443. 压缩字符串
 *
 * 给定一组字符，使用原地算法将其压缩。

 压缩后的长度必须始终小于或等于原数组长度。

 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。

 在完成原地修改输入数组后，返回数组的新长度。

 */
public class Compress {
    public int compress(char[] chars) {

        int write = 0;
        for (int read = 0; read < chars.length;){
            int j = read + 1;
            while (j < chars.length && chars[j] == chars[read]) j++;
            chars[write++] = chars[read];
            if (j - read > 1){
                String temp = (j - read) + "";
                for (char c:temp.toCharArray()){
                    chars[write++] = c;
                }
            }
            read = j;
        }
        return write;
    }
}
