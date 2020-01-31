package algorithms.top100;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyuan on 2019/12/29.
 *
 * 注意理解思路  ****  看了答案之后写的，还不是很理解
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

 例如，给出 n = 3，生成结果为：

 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]

 */
public class GenerateParenthesis {

    public static void main(String[] args) {

        System.out.println(JSON.toJSONString(generateParenthesis(2)));
    }
//
//    public static List<String> generateParenthesis(int n) {
//        List<String> ans = new ArrayList();
//        backtrack(ans, "", 0, 0, n);
//        return ans;
//    }

//    public static void backtrack(List<String> ans, String cur, int open, int close, int max){
//        if (cur.length() == max * 2) {
//            ans.add(cur);
//            return;
//        }
//
//        if (open < max)
//            backtrack(ans, cur+"(", open+1, close, max);
//        if (close < open)
//            backtrack(ans, cur+")", open, close+1, max);
//    }




    private static  List<String> generateParenthesis(int n){
        List<String> result = new ArrayList<>();
        solution(result, "", 0 , 0, n);
        return result;
    }

//如果我们还剩一个位置，我们可以开始放一个左括号。 如果它不超过左括号的数量，我们可以放一个右括号。

    private static  void solution(List<String> result, String cur, int open, int close, int max){
        if (cur.length() == 2*max){
            result.add(cur);
            return;
        }
        if (open < max){
            solution(result, cur + "(", open + 1, close, max);
        }
        if (close < open){//注意这里的条件是 close < open ,不是 close <max
            solution(result, cur + ")", open, close + 1, max);
        }
    }

}
