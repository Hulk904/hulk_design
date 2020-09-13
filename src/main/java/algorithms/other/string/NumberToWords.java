package algorithms.other.string;

/**
 * Created by yangyuan on 2020/8/29.
 * 273. 整数转换英文表示
 * 将非负整数转换为其对应的英文表示。可以保证给定输入小于 2e31 - 1 。
 */
public class NumberToWords {
    String[] num0To19 = new String[]{"Zero", "One", "Two", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
            "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    String[] num20To90 = new String[]{"Twenty", "Thirty", "Forty", "Fifty", "Sixty",
            "Seventy", "Eighty", "Ninety"};

    String[] num1000 = new String[]{"Billion ", "Million ", "Thousand ", ""};

    /**
     * 三个一组来处理
     * @param num
     * @return
     */
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        String res = "";
        for (int i = 1000000000, j = 0; i >= 1; i/=1000, j++){
            if (num >= i){
                res += get(num/i) + num1000[j];
                num%=i;
            }
        }
        return res.substring(0, res.length() - 1);
    }

    /**
     * 返回1 ～999的英文表示
     * @param x
     * @return
     */
    private String get(int x){
        StringBuilder sb = new StringBuilder();
        if (x >= 100){
            sb.append(num0To19[x/100] + " Hundred ");
            x%=100;
        }
        if (x>=20){
            sb.append(num20To90[x/10 -2] + " ");
            x%=10;
            if ( x != 0)sb.append(num0To19[x] + " ");
        } else if(x != 0) {
            sb.append(num0To19[x] + " ");
        }
        return sb.toString();
    }
}
