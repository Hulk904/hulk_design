package algorithms.other.string;

/**
 * Created by yangyuan on 2020/10/18.
 * 415. 字符串相加
 *
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 */
public class AddStrings {

    //高精度加法模版
    public String addStrings(String num1, String num2) {
        int[] A = new int[num1.length()];
        int[] B = new int[num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) A[num1.length() - i - 1] = num1.charAt(i) - '0';
        for (int i = num2.length() - 1; i >= 0; i--) B[num2.length() - i - 1] = num2.charAt(i) - '0';
        int[] C = add(A, B);
        StringBuilder sb = new StringBuilder();
        for (int i = C.length - 1; i >= 0; i--) {
            if (i == C.length - 1 && C[C.length - 1] == 0) continue;
            sb.append(C[i]);
        }
        return sb.toString();
    }
    int[] add(int[] A, int[] B){
        int[] C = new int[Math.max(A.length, B.length) + 1];
        for (int i = 0, t = 0; i < A.length || i < B.length || t > 0; i++){
                if (i < A.length) t += A[i];
                if (i < B.length) t += B[i];
                C[i] = t%10;
                t = t/10;
        }
        return C;
    }
}
