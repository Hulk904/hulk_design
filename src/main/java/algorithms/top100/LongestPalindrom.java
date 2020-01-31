package algorithms.top100;

/**
 * Created by yangyuan on 2019/12/27.
 * 最长回文子串
 * 整个思路还是由中心往两边找 然后遍历整个字符串。
 */
public class LongestPalindrom {
    public static void main(String[] args) {
        String str = "";
        System.out.println(solution(str));
    }

    public static String solution(String str){
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
}
