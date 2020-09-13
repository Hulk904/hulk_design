package algorithms.other;

/**
 * Created by yangyuan on 2020/4/27.
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class LongestCommonPrefix {

    /**
     * 水平方向 匹配
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++){
            int j = 0;
            for (; j < ans.length() && j < strs[i].length(); j++){
                if (ans.charAt(j) != strs[i].charAt(j)){
                    break;
                }
            }
            ans = ans.substring(0, j);
            if ("".equals(ans)) {
                return "";
            }
        }
        return ans;
    }
    /**
     * 二分查找
     */


    /**
     * trie树
     */
}
