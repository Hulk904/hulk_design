package algorithms.other.string;

/**
 * Created by yangyuan on 2021/4/28.
 * 796. 旋转字符串
 *
 * 给定两个字符串, A 和 B。

 A 的旋转操作就是将 A 最左边的字符移动到最右边。 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea' 。如果在若干次旋转操作之后，A 能变成B，那么返回True。



 */
public class RotateString {

    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) return false;
        A = A + A;
        return A.contains(B);
    }

    //字符串哈希hash
    //可以用o(1)的时间判断字符串是否相等，不管有多长
    int N = 210, P = 131;
    long h [] = new long[N];
    long p [] = new long[N];
    public boolean rotateString2(String A, String B) {
        if (A.equals(B)) return true;
        String s = " " + A + B;
        int n = s.length() - 1;
        p[0] = 1;
        for (int i = 1; i <= n; i++){
            p[i] = p[i - 1]*P;
            h[i] = h[i - 1]*P + s.charAt(i);
        }
        for (int k = 1; k < A.length(); k++){
            //A = m + n
            //B = n + m
            //交叉判断相等
            if (get(1, k) == get(n - k + 1, n) && get(k + 1, A.length()) == get(A.length() + 1, n - k)){
                return true;
            }
        }
        return false;
    }
    //求某一段hash值
    //前缀和技巧
    long get(int l, int r){
        return h[r] - h[l - 1]*p[r - l + 1];
    }

}
