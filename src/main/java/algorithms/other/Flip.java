package algorithms.other;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by yangyuan on 2020/11/15.
 *
 * 519. 随机翻转矩阵
 *
 * 题中给出一个 n_rows 行 n_cols 列的二维矩阵，且所有值被初始化为 0。要求编写一个 flip 函数，均匀随机的将矩阵中的 0 变为 1，
 * 并返回该值的位置下标 [row_id,col_id]；同样编写一个 reset 函数，将所有的值都重新置为 0。尽量最少调用随机函数 Math.random()，
 * 并且优化时间和空间复杂度。

 */
public class Flip {

    // 按行展开为1维（删除元素后，还连续 ==>  用最后一个元素覆盖删除的，然后把最后的删除）

    int r, c, k;//k 表示剩余个数
    Map<Integer, Integer> map = new HashMap();

    public Flip(int n_rows, int n_cols) {
        r = n_rows;
        c = n_cols;
        k = r*c;
    }

    public int[] flip() {
        int x = new Random().nextInt(k);
        int y = map.getOrDefault(x, x);
        if (map.get(k - 1) != null){
            map.put(x, map.get(k - 1));
            map.remove(k - 1);
        } else {
            map.put(x, k - 1);
        }
        k--;
        return new int[] {y/c, y%c};
    }

    public void reset() {
        k = r*c;
        map.clear();
    }
}
