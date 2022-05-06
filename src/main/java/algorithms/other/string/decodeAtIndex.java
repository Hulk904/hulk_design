package algorithms.other.string;

/**
 * Created by yangyuan on 2021/5/29.
 * 880. 索引处的解码字符串
 * 给定一个编码字符串 S。请你找出 解码字符串 并将其写入磁带。解码时，从编码字符串中 每次读取一个字符 ，并采取以下步骤：

 如果所读的字符是字母，则将该字母写在磁带上。
 如果所读的字符是数字（例如 d），则整个当前磁带总共会被重复写 d-1 次。
 现在，对于给定的编码字符串 S 和索引 K，查找并返回解码字符串中的第 K 个字母。

 */
public class DecodeAtIndex {
    public String decodeAtIndex(String s, int k) {
        long n = 0;//解码后的总长度
        for (char c:s.toCharArray()){
            if (Character.isDigit(c)) n*=c - '0';
            else n++;
        }
        for (int i = s.length() - 1; i >= 0; i--){
            char c = s.charAt(i);
            if (Character.isDigit(c)){
                int x = c - '0';
                n/=x;
                k%=n;
                if (k == 0) k = (int)n;
            } else {
                if (n == k) return c + "";
                n--;
            }
        }
        return "";
    }
}
