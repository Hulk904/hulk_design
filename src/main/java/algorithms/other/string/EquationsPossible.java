package algorithms.other.string;

/**
 * Created by yangyuan on 2021/7/18.
 * 990. 等式方程的可满足性
 *
 给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。

 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。


 */
public class EquationsPossible {
    int[] p;

    int find(int x){
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
    public boolean equationsPossible(String[] equations) {
        p = new int[26];
        for (int i = 0; i < 26; i++){
            p[i] = i;
        }
        for (String e:equations){
            int  a = e.charAt(0) - 'a', b = e.charAt(3) - 'a';
            if (e.charAt(1) == '='){
                if (find(a) != find(b)){
                    p[find(a)] = find(b);
                }
            }
        }
        for (String e:equations){
            int  a = e.charAt(0) - 'a', b = e.charAt(3) - 'a';
            if (e.charAt(1) == '!'){
                if (find(a) == find(b)){
                    return false;
                }
            }
        }
        return true;
    }
}
