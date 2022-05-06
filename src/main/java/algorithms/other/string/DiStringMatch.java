package algorithms.other.string;

/**
 * Created by yangyuan on 2021/6/27.
 * 942. 增减字符串匹配
 * 给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。

 返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：

 如果 S[i] == "I"，那么 A[i] < A[i+1]
 如果 S[i] == "D"，那么 A[i] > A[i+1]

 */
public class DiStringMatch {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] res = new int[n + 1];
        int l = 0, r = n;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == 'I') res[i] = l++;
            else res[i] = r--;
        }
        res[n] = l;
        return res;
    }
}
