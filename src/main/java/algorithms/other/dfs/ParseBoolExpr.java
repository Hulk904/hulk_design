package algorithms.other.dfs;

/**
 * Created by yangyuan on 2022/1/3.
 * 1106. 解析布尔表达式
 * 给你一个以字符串形式表述的 布尔表达式（boolean） expression，返回该式的运算结果。
 有效的表达式需遵循以下约定：
 "t"，运算结果为 True
 "f"，运算结果为 False
 "!(expr)"，运算过程为对内部表达式 expr 进行逻辑 非的运算（NOT）
 "&(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 与的运算（AND）
 "|(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 或的运算（OR）
 */
public class ParseBoolExpr {
    String str;
    int k = 0;
    public boolean parseBoolExpr(String expression) {
        this.str = expression;
        return dfs();
    }
    boolean dfs(){
        if (str.charAt(k) == 't'){
            k++;
            return true;
        }
        if (str.charAt(k) == 'f'){
            k++;
            return false;
        }
        char op = str.charAt(k);//当前操作符
        k+=2;
        boolean res = true;
        if (op == '|') res = false;
        while (str.charAt(k) != ')'){
            if (str.charAt(k) == ','){
                k++;
            } else {//每一项都需要递归处理
                boolean t = dfs();
                if (op == '|') res |= t;
                else res &= t;
            }
        }
        k++;//跳过左括号
        if (op == '!') res = !res;
        return res;
    }
}
