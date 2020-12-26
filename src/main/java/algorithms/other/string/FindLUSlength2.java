package algorithms.other.string;

/**
 * Created by yangyuan on 2020/11/21.
 * 522. 最长特殊序列 II
 *
 * 给定字符串列表，你需要从它们中找出最长的特殊序列。最长特殊序列定义如下：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。

 子序列可以通过删去字符串中的某些字符实现，但不能改变剩余字符的相对顺序。空序列为所有字符串的子序列，任何字符串为其自身的子序列。

 输入将是一个字符串列表，输出是最长特殊序列的长度。如果最长特殊序列不存在，返回 -1 。



 */
public class FindLUSlength2 {

    //某序列是特殊序列，则整体也是特殊序列  ===>  答案是某个串
    public int findLUSlength(String[] strs) {
        int res = -1;
        for (int i = 0; i < strs.length; i++){
            boolean isSub = false;
            for (int j = 0; j < strs.length; j++){
                if (i != j && check(strs[i], strs[j])){
                    isSub = true;
                    break;
                }
            }
            if (!isSub){
                res = Math.max(res, strs[i].length());
            }
        }
        return res;
    }
    //判断某个序列是不是另一个序列的子序列  模板题。 o(n) 时间复杂度
    boolean check (String a, String b){
        int k = 0;
        for (char c:b.toCharArray()){
            if (k < a.length() && c == a.charAt(k)){
                k++;
            }
        }
        return k == a.length();
    }
}
