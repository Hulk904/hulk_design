package algorithms.other;

/**
 * Created by yangyuan on 2021/6/6.
 * 900. RLE 迭代器
 * 编写一个遍历游程编码序列的迭代器。

 迭代器由 RLEIterator(int[] A) 初始化，其中 A 是某个序列的游程编码。更具体地，对于所有偶数 i，A[i] 告诉我们在序列中重复非负整数值 A[i + 1] 的次数。

 迭代器支持一个函数：next(int n)，它耗尽接下来的  n 个元素（n >= 1）并返回以这种方式耗去的最后一个元素。如果没有剩余的元素可供耗尽，则  next 返回 -1 。

 例如，我们以 A = [3,8,0,9,2,5] 开始，这是序列 [8,8,8,5,5] 的游程编码。这是因为该序列可以读作 “三个八，零个九，两个五”。

 */
public class RLEIterator {
    int[] q;
    int k = 0;//当前走到哪个位置了

    public RLEIterator(int[] encoding) {
        q = encoding;
    }

    public int next(int n) {
        while (k < q.length && n > q[k]){//未出界、 不够走
            n -= q[k];
            k+=2;
        }
        if (k >= q.length) return -1;
        q[k] -= n;
        return q[k + 1];
    }
}
