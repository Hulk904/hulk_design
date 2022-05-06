package algorithms.other;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangyuan on 2020/4/26.
 * 914. 卡牌分组
 *
 * 给定一副牌，每张牌上都写着一个整数。

 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：

 每组都有 X 张牌。
 组内所有的牌上都写着相同的整数。
 仅当你可选的 X >= 2 时返回 true。

 */
public class HasGroupsSizeX {

    /**
     * 最开始的思路 计数，然后比较次数是不是都是一样的（次数都大于1）
     * 这样的问题是比如 1，1，2，2，2，2  其实是可以的。上面的思路就不行，2可以分两组，每组两个
     *
     * 最终解答 最大公约数大于1才是正解
     * @param deck
     * @return
     */
    public boolean hasGroupsSizeX(int[] deck) {
        int[] count = new int[10000];
        for (int i:deck){
            count[i]++;
        }
        int gcd = -1;
        for (int i = 0; i < count.length; i++){
            if (count[i] > 0){
                if (gcd == -1){
                    gcd = count[i];
                } else {
                    gcd = gcd(gcd, count[i]);
                }
            }
        }
        return gcd >= 2;
    }

    /**
     * 求x ，y的最大公约数 递归实现
     * @param x
     * @param y
     * @return
     */
    private int gcd(int x, int y){
        return x == 0 ? y : gcd(y%x, x);
    }

    public boolean hasGroupsSizeXShort(int[] deck) {
        Map<Integer, Integer> map = new HashMap();
        for (int x:deck) map.put(x, map.getOrDefault(x, 0) + 1);
        int d = 0;
        for (Map.Entry<Integer, Integer> entry:map.entrySet()) d = gcd2(d, entry.getValue());
        return d >= 2;
    }
    int gcd2(int a, int b){
        return b == 0 ? a : gcd2(b, a%b);
    }
}
