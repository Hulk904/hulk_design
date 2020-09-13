package algorithms.other;

/**
 * Created by yangyuan on 2020/4/22.
 * 38. 外观数列
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 1.     1
 2.     11
 3.     21
 4.     1211
 5.     111221
 1 被读作  "one 1"  ("一个一") , 即 11。
 11 被读作 "two 1s" ("两个一"）, 即 21。
 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
 */
public class CountAndSay {

    public String countAndSay(int n) {
        if (n == 1){
            return "1";
        }
        return helper(countAndSay(n - 1));
    }

    /**
     * 根据现有的串生成下一个串
     * @param s
     * @return
     */
    private String helper(String s){
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char pre = s.charAt(0);
        for (int i = 1; i < s.length(); i++){
            if (pre == s.charAt(i)){
                count++;
            } else {
                sb.append(count + "" + pre);
                count = 1;
                pre = s.charAt(i);
            }
        }
        sb.append(count + "" + pre);//最后的元素别忘了
        return sb.toString();
    }

    public String countAndSay2(int n) {
        String s = "1";
        for (int i = 0; i < n - 1; i++){
            String temp = "";
            for (int j = 0; j < s.length();){
                int k = j + 1;
                while (k < s.length() && s.charAt(k) == s.charAt(j)) k++;
                temp += (k-j) + ""+ s.charAt(j);//这里得注意转换为字符串，不然 int + char 返回的是 int ，而不是拼接的字符串
                j = k;
            }
            s = temp;
        }
        return s;
    }

}
