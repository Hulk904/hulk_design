package algorithms.other;

/**
 * Created by yangyuan on 2020/7/25.
 * 125. 验证回文串
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

 说明：本题中，我们将空字符串定义为有效的回文串。


 */
public class IsPalindrome3 {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j){
            if (!Character.isLetterOrDigit(s.charAt(i))){
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(j))){
                j--;
                continue;
            }
            if (s.charAt(i) != s.charAt(j) ||
                    s.charAt(i) != (char)(s.charAt(j)^32)
                    ){
                return false;
            }
        }
        return true;
    }
}
