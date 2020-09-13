package algorithms.other.btree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyuan on 2020/8/23.
 * 241. 为运算表达式设计优先级
 * 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。

 */
public class DiffWaysToCompute {

    List<String> expr = new ArrayList();

    public List<Integer> diffWaysToCompute(String input) {
        /*
        拆开  数字 和运算符
         */
        for (int i = 0; i < input.length(); i++){
            if (Character.isDigit(input.charAt(i))){
                int j = i, res = 0 ;
                while (j < input.length() && Character.isDigit(input.charAt(j))){
                    res = res*10 + (input.charAt(j++) - '0');
                }
                i = j - 1;
                expr.add("" + res);
            } else {
                expr.add("" + input.charAt(i));
            }
        }
        return dfs(0, expr.size() - 1);

    }

    private List<Integer> dfs(int l, int r){
        if (l == r) {//只有一个数 直接返回数字本身
            List<Integer> res = new ArrayList();
            res.add(Integer.parseInt(expr.get(l)));
            return res;
        }
        List<Integer> res = new ArrayList();
        //操作符 间隔的， 所以每次 += 2
        //枚举所有操作符，第一个是数字，所以从第二个开始. 右边界是r  而不是 expr.size()
        for (int i = l + 1; i < r; i+=2){
            List<Integer> left = dfs(l, i - 1);
            List<Integer> right = dfs(i + 1, r);
            for (int a:left){
                for (int b:right){
                    int temp = 0;
                    if (expr.get(i).equals("+")){
                        temp = a + b;
                    } else if (expr.get(i).equals("-")){
                        temp = a - b;
                    } else {
                        temp = a*b;
                    }
                    res.add(temp);
                }
            }
        }
        return res;
    }
}
