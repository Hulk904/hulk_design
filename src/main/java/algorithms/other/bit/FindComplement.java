package algorithms.other.bit;

/**
 * Created by yangyuan on 2020/11/7.
 * 476. 数字的补数
 * 给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
 */
public class FindComplement {

    public static void main(String[] args) {
        FindComplement f = new FindComplement();
        f.findComplement(5);
    }

    public int findComplement(int num) {
        int temp = num;
        int cnt = 0;
        while (num > 0){
            num >>= 1;
            cnt ++;
        }
        System.out.println(cnt);
        return temp ^ ((1<<cnt) - 1);
    }
}
