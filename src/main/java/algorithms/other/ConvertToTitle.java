package algorithms.other;

/**
 * Created by yangyuan on 2020/8/8.
 *
 * 168. Excel表列名称
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 */
public class ConvertToTitle {

    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0){
            int yu = n%26;
            if (yu == 0){
                sb.insert(0, 'Z');
                n = (n/26) - 1;
            } else {
                sb.insert(0, (char)('A' + n%26 - 1));
                n/=26;
            }
        }
        return sb.toString();
    }

    public String convertToTitle2 (int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int c = n % 26;
            if(c == 0){
                c = 26;
                n -= 1;
            }
            sb.insert(0, (char) ('A' + c - 1));
            n /= 26;
        }
        return sb.toString();
    }

}
