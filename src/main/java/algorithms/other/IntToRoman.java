package algorithms.other;

/**
 * Created by yangyuan on 2020/6/14.
 * 12. 整数转罗马数字
 *
 */
public class IntToRoman {

    static int[] values = {
            1000,
            900, 500, 400, 100,
            90, 50, 40, 10,
            9,5, 4, 1
    };

    static String reps[] = {
            "M",
            "CM", "D", "CD", "C",
            "XC", "L", "XL", "X",
            "IX", "V", "IV", "I"

    };

    public static void main(String[] args) {
        IntToRoman intToRoman = new IntToRoman();
        System.out.println(intToRoman.intToRoman(4));
    }


    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i <= 12; i++){
            while (num >= values[i]){
                num -= values[i];
                sb.append(reps[i]);
            }
        }
        return sb.toString();
    }

}
