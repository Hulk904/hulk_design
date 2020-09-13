package algorithms.top100;

/**
 * Created by yangyuan on 2019/12/27.
 * 最长回文子串
 * 整个思路还是由中心往两边找 然后遍历整个字符串。
 */
public class LongestPalindrom {
    public static void main(String[] args) {
        String str = "cbbd";
        System.out.println(longestPalindrome3(str));
    }

    /**
     * 逻辑跟下面的类似，但是写的比较啰嗦
     *   （n-1）/2 和 n/2 奇数的时候相同，偶数的时候差1
     *   所以 可以更简洁的表达
     *   if (temp > end - start){
            start = i - (temp-1)/2;
            end = i + temp/2 ;
         }
     * @param s
     * @return
     */
    public static String longestPalindrome(String s){
        if (s == null || "".equals(s)){
            return "";
        }
        int max = 0;
        int left = 0, right = 0;
        for (int i = 0; i< s.length(); i++){
            int one = distance(s, i, i);
            int oneDistance = 2*one - 1;
            if (oneDistance > max){
                max = oneDistance;
                left = i - (one - 1);
                right = i + (one - 1);
            }
            int two = distance(s, i, i + 1);
            int twoDistance = 2*two;
            if (twoDistance > max){
                max = twoDistance;
                left = i - (two - 1);
                right = i + (two - 1) + 1;
            }
        }
        return s.substring(left, right + 1);
    }

    private static int distance(String s, int left, int right){
        if (right >= s.length()){
            return 0;
        }
        int max = 0;
        while (left >= 0
                && right < s.length()
                && s.charAt(left) == s.charAt(right)){
            max++;
            left--;
            right++;
        }
        return max;
    }

    public static String longestPalindrome2(String str){
        if (str == null || str == ""){
            return "";
        }
        int start = 0;
        int end = 0;
        for (int i =0; i < str.length(); i++){
            int len1=maxDis(str, i , i);
            int len2=maxDis(str, i, i + 1);
            int temp = Math.max(len1, len2);
            if (temp > end - start){
                start = i - (temp-1)/2;//注意2
                end = i + temp/2 ;//注意2
            }
        }
        return str.substring(start, end + 1);//注意1
    }

    private static int maxDis(String s, int left, int right){
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }

    /**
     * 代码相对简洁些  但是慢  （感觉是字符串增长是都会截取一次字符串）
     * @param str
     * @return
     */
    public static String longestPalindrome3(String str){
        String res = "";
        for (int i = 0; i < str.length(); i++){
            int l = i - 1, r= i + 1;
            while (l >=0 && r < str.length() && str.charAt(l) == str.charAt(r)) {
                l--;r++;
            }
            if (res.length() < r - l - 1) res = str.substring(l + 1, r);
            l = i; r = i + 1;
            while (l >= 0 && r <str.length() && str.charAt(l) == str.charAt(r)){
                l--;
                r++;
            }
            if (res.length() < r - l - 1) res = str.substring(l + 1, r);
        }
        return res;
    }
}
