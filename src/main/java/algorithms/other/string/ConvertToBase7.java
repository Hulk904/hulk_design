package algorithms.other.string;

/**
 * Created by yangyuan on 2020/11/14.
 * 504. 七进制数
 *
 * 给定一个整数，将其转化为7进制，并以字符串形式输出。
 */
public class ConvertToBase7 {

    public String convertToBase7(int num) {
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        int x = num > 0 ? 1 : -1;
        num = Math.abs(num);
        while (num > 0){
            sb.append(num%7);
            num = num/7;
        }
        String res = sb.reverse().toString();
        return x > 0 ? res: "-" + res;
    }
}
