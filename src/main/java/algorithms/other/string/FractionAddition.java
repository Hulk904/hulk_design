package algorithms.other.string;

/**
 * Created by yangyuan on 2020/12/5.
 *
 * 592. 分数加减运算
 给定一个表示分数加减运算表达式的字符串，你需要返回一个字符串形式的计算结果。 这个结果应该是不可约分的分数，即最简分数。 
 如果最终结果是一个整数，例如 2，你需要将它转换成分数形式，其分母为 1。所以在上述例子中, 2 应该被转换为 2/1。

 */
public class FractionAddition {
    int gcd (int a, int b){
        return a == 0 ? b : gcd(b%a, a);
    }

    public String fractionAddition(String expression) {
        int a = 0, b = 1;
        int offset = 0;
        if (expression.charAt(0) != '-') expression = "+" + expression;
        for (int i = 1; i < expression.length(); i++){
            int  start = i;
            while (i < expression.length() && (expression.charAt(i) != '+' && expression.charAt(i) != '-')) i++;
            offset = i;
            if (offset == 0) continue;
            int index = expression.indexOf('/', start + 1);
            int c = Integer.parseInt(expression.substring(start, index));
            int d = Integer.parseInt(expression.substring(index + 1, offset));
            if (start > 0 && expression.charAt(start - 1) == '-'){
                c = -c;
            }
            int x = a*d + b*c;
            int y = b*d;
            int z = gcd(x, y);
            a = x/z;
            b = y/z;
        }
        if (b < 0){
            a = -a;
            b = -b;
        }
        return a + "/" + b;
    }
}
