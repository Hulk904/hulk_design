package algorithms.other.string;

/**
 * Created by yangyuan on 2020/10/24.
 *
 * 424. 替换后的最长重复字符
 *
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，
 * 总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
 */
public class CharacterReplacement {

    int[] map = new int[26];
    public int characterReplacement(String s, int k) {

        int left = 0;
        int right = 0;
        int max = 0;
        for (; right < s.length(); right++){
            int index = s.charAt(right) - 'A';
            map[index]++;
            max = Math.max(max, map[index]);
            if (right - left + 1 > max + k){
                map[s.charAt(left) - 'A']--;
                left++;
            }
        }
        return right - left;
    }


    /**
     * acwing 视频题解  枚举 A～ Z  ，然后里面进行  双指针操作（因为这样好证明些）
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement2(String s, int k) {
        int res = 0;
        for (char c = 'A'; c <= 'Z'; c++){
            for (int i = 0, j = 0, cnt = 0; i < s.length(); i++){
                if (s.charAt(i) == c) cnt++;
                while (i - j + 1 - cnt > k){
                    if (s.charAt(j) == c) cnt--;
                    j++;
                }
                res = Math.max(res, i - j + 1);
            }
        }
        return res;
    }
}
