package algorithms.other.array;

/**
 * Created by yangyuan on 2021/3/25.
 * 差分
 * 给定一个数组
 * 然后执行 n 个操作。 对[l,r]的每个数加上 n
 * 最后返回数组的情况
 */
public class Chafen {

    int[]a;//原数组
    int[]b;//差分数组

    private void insert(int l, int r, int c){
        b[l] += c;
        b[r + 1] -= c;
    }

    public  void cc() {
        int n = a.length - 1;
        //构造差分数组
        for (int i = 1; i <= n; i++){
            insert(i, i, a[i]);
        }

        //执行 加 n的操作
        //insert(l, r, n)
        //最后返回原数组变化的结果，即对b数组进行前缀和计算。
    }

}
