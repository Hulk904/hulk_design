package algorithms.other.bit;

/**
 * Created by yangyuan on 2020/8/9.
 * 190. 颠倒二进制位
 * 颠倒给定的 32 位无符号整数的二进制位。
 */
public class ReverseBits {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++){
            res = res * 2 + ((n>>i) & 1);
        }
        return res;
    }
}
