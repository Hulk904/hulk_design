package algorithms.other.string;

/**
 * Created by yangyuan on 2020/11/1.
 *
 * 467. 环绕字符串中唯一的子字符串
 *
 * 把字符串 s 看作是“abcdefghijklmnopqrstuvwxyz”的无限环绕字符串，所以 s 看起来是这样的："...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....". 

 现在我们有了另一个字符串 p 。你需要的是找出 s 中有多少个唯一的 p 的非空子串，尤其是当你的输入是字符串 p ，你需要输出字符串 s 中 p 的不同的非空子串的数目。 

 注意: p 仅由小写的英文字母组成，p 的大小可能超过 10000。

 */
public class FindSubstringInWraproundString {

    public static void main(String[] args) {
        FindSubstringInWraproundString s = new FindSubstringInWraproundString();
        s.findSubstringInWraproundString("zabab");
    }

    //    p里有多少个子串（连续的）
    public int findSubstringInWraproundString(String p) {
        int[] dp = new int[26];
        int n = p.length();
        int k = 0;
        for (int i = 0; i < n; i++){
            if (i > 0 && continous(p.charAt(i - 1), p.charAt(i))){
                k++;
            } else {
                k = 1;
            }
            dp[p.charAt(i) - 'a'] = Math.max(dp[p.charAt(i) - 'a'], k);
        }
        int res = 0;
        //zabab  和zab 得到的 dp数组是一样的。因为zab里面 a、b已经是最大的了，后面的ab不会影响相关值。zab  计算的是以 z，a，b结尾的最长的，这样比较方便
        //acwing里面是 以 开头计算的。
        for (int i:dp){
            res += i;
        }
        return res;
    }

    boolean continous(char p, char c){
        if (p == 'z') return c == 'a';
        return p + 1 == c;
    }
}
