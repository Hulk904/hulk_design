package algorithms.other.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyuan on 2020/9/12.
 * 301. 删除无效的括号
 * 删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。

    说明: 输入可能包含了除 ( 和 ) 以外的字符。
 *
 *  合法括号对条件
 *  1、左右括号数量相同
 *  2、任意一个前缀中左括号数量>=右括号数量
 */
public class RemoveInvalidParentheses {

    List<String> ans = new ArrayList<>();

    public List<String> removeInvalidParentheses(String s) {
        int l = 0, r = 0;// l 表示 当前左括号数量减去右括号数量（也就是要删掉的左括号数）， r表示当前要删除多少个右括号
        for (char x:s.toCharArray()){
            if (x == '(') l++;
            else if (x == ')'){
                if (l == 0) r ++;//说明左右一样，需要把右括号删掉
                else l--;
            }
        }
        dfs(s, 0, "", 0 , l , r);
        return ans;
    }

    /**
     *
     * @param s
     * @param u 枚举到那个了
     * @param path 当前删除之后剩余的串
     * @param cnt  当前做括号减去右括号数量
     * @param l  当前可以删掉的左括号数量
     * @param r 当前可以删掉的右括号数量
     */
    void dfs(String s,int u, String path, int cnt, int l, int r){
        if (u == s.length()){
            if (cnt == 0) ans.add(path);//左右相同
            return;
        }
        //当前字符既不是做括号也不是右括号
        if (s.charAt(u) != '(' && s.charAt(u) != ')') dfs(s, u + 1, path + s.charAt(u), cnt, l , r);
        else if (s.charAt(u) == '('){
            /*
             当前多少个连续左括号
             */
            int k = u;
            while ( k < s.length() && s.charAt(k) == '(') k++;
            l -= (k - u);
            //当前到底删掉左括号
            for (int i = k - u; i>=0; i--){
                if (l >= 0) dfs(s, k, path, cnt, l, r);
                path+= '(';
                cnt++;
                l++;
            }
        } else if (s.charAt(u) == ')'){
            int k = u;
            while (k < s.length() && s.charAt(k) == ')') k++;
            r -= (k - u);
            for (int i = k - u; i >= 0; i--){
                if (cnt >= 0 && r >= 0) dfs(s, k, path, cnt, l, r);
                path+=')';
                cnt--;
                r++;
            }
        }
    }
}
