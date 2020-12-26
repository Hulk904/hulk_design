package algorithms.other.string;

/**
 * Created by yangyuan on 2020/11/22.
 * 541. 反转字符串 II
 *
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。

 如果剩余字符少于 k 个，则将剩余字符全部反转。
 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。

 */
public class ReverseStr {

    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2*k){
            int m = i, j = Math.min(i + k - 1, s.length() - 1);
            while (m < j){
                char temp = arr[m];
                arr[m] = arr[j];
                arr[j] = temp;
                m++;j--;
            }
        }
        return new String(arr);
    }
}
