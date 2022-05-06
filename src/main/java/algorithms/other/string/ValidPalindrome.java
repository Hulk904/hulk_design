package algorithms.other.string;

/**
 * Created by yangyuan on 2021/3/7.
 * 680. 验证回文字符串 Ⅱ
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串
 */
public class ValidPalindrome {
    //这样的思路比较 简单
    public boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--){
            if (s.charAt(i) != s.charAt(j)){
                if (check(s, i + 1, j) || check(s, i, j - 1)) return true;
                return false;
            }
        }
        return true;
    }

    boolean check (String s, int i, int j){
        while (i < j){
            if (s.charAt(i) != s.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }
}
