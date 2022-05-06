package algorithms.other;

/**
 * Created by yangyuan on 2021/3/13.
 * 693. 交替位二进制数
 *
 * 给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：换句话说，就是二进制表示中相邻两位的数字永不相同。
 */
public class HasAlternatingBits {

    public boolean hasAlternatingBits(int n) {
        String s = Integer.toBinaryString(n);
        for (int i = 1; i < s.length(); i++){
            if (s.charAt(i) == s.charAt(i - 1)) return false;
        }
        return true;
    }

    /**
     * 判断n ^ (n>>1) 是否每一位全为1
     * @param n
     * @return
     */
    public boolean hasAlternatingBits2(int n){
        n = (n ^ (n>>1));
        return (n & ((long)n+1)) == 0;
    }
}
