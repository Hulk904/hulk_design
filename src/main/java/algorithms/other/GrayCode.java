package algorithms.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyuan on 2020/4/14.
 * 89. 格雷编码
 *
 * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。

 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。格雷编码序列必须以 0 开头

 */
public class GrayCode {

    public static void main(String[] args) {
        grayCode(4);
    }

    /**
     * 这是数学方法。
     * 对现有的元素 元素倒序加1 然后再插入到数组中
     * @param n
     * @return
     */
    public static List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>() {{ add(0); }};
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--)
                res.add(head + res.get(j));
            head <<= 1;
        }
        return res;
    }
}
