package algorithms.other;

/**
 * Created by yangyuan on 2020/6/13.
 * 7. 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 注意:

 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，
 如果反转后整数溢出那么就返回 0。
 所以不能用long 来存放变量 判断是否溢出
 */
public class Reverse {

    public static void main(String[] args) {
        System.out.println(reverse(-12));
    }

    public static int reverse(int x) {
         int res = 0;
         while (x != 0){
             if ( x > 0 && res > (Integer.MAX_VALUE - x % 10)/10) return 0;
             //这里x小于0， 所以 Integer.MIN_VALUE -x  不会越界的。
             if ( x < 0 && res < (Integer.MIN_VALUE -x % 10)/10) return 0;
             res = res*10 + x%10;
             x/=10;
         }
        return res;
    }


}
