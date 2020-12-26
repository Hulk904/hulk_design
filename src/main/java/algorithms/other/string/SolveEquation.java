package algorithms.other.string;

/**
 * Created by yangyuan on 2020/12/24.
 * 640. 求解方程
 *
 * 求解一个给定的方程，将x以字符串"x=#value"的形式返回。该方程仅包含'+'，' - '操作，变量 x 和其对应系数。

 如果方程没有解，请返回“No solution”。

 如果方程有无限解，则返回“Infinite solutions”。

 如果方程中只有一个解，要保证返回值 x 是一个整数。

 */
public class SolveEquation {

    public String solveEquation(String equation) {
        int k = equation.indexOf("=");
        int[] left = compute(equation.substring(0, k));
        int[] right = compute(equation.substring(k + 1));
        int a = left[0] - right[0];
        int b = right[1] - left[1];
        if (a == 0){
            if (b == 0){
                return "Infinite solutions";
            }
            return "No solution";
        }
        return "x=" + b/a;
    }

    int[] compute(String str){
        int a = 0, b = 0;
        if (str.charAt(0) != '+' && str.charAt(0) != '-') str  = "+" + str;//前面补个 + 容易处理
        for (int i = 0; i < str.length(); i++){
            int j = i + 1;//i 指向的是符号
            while (j < str.length() && Character.isDigit(str.charAt(j))) j++;
            int c = 1;//有可能 是 x ，前面的系数是 1
            if (i + 1 <= j - 1) c = Integer.parseInt(str.substring(i + 1, j));
            if (str.charAt(i) == '-') c = -c;//如果是符号
            if (j < str.length() && str.charAt(j) == 'x'){// 是一项式
                a += c;
                i = j;
            } else { //是常数式
                b += c;
                i = j - 1;
            }
        }
        return new int[]{a, b};
    }
}
