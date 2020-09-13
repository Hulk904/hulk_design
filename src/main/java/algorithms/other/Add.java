package algorithms.other;

/**
 * Created by yangyuan on 2020/4/17.
 * 面试题 17.01. 不用加号的加法
 * 设计一个函数把两个数字相加。不得使用 + 或者其他算术运算符。
 */
public class Add {

    public static void main(String[] args) {

        Add add = new Add();
        add.add(13 ,5);
    }

    public int add(int a, int b) {
        while (b != 0) {
            int sum = (a ^ b);
            int carry = (a & b) << 1;
            a = sum;
            b = carry;
        }

        return a;

    }
}
