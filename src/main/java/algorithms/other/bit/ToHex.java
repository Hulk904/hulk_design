package algorithms.other.bit;

/**
 * Created by yangyuan on 2020/10/17.
 * 405. 数字转换为十六进制数
 *
 * 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
 */
public class ToHex {

    public static void main(String[] args) {
        int a = -8;
        System.out.println(a>>>1);
    }

    public String toHex(int num) {

        if(num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        String nums = "0123456789abcdef";
        while (num != 0){
            sb.append(nums.charAt(num&0xf));
            num = num>>>4;//注意这个操作，是逻辑右移，不管符号了
        }
        sb.reverse();
        return sb.toString();
    }
}
