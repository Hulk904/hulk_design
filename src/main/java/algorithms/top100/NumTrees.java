package algorithms.top100;

/**
 * Created by yangyuan on 2020/1/12.
 * 96. 不同的二叉搜索树
 *
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 主要是递推出公式
 */
public class NumTrees {

    public static void main(String[] args) {
        System.out.println(numTrees(2));
    }

    public static int numTrees(int n) {
        if (n == 1) return 1;
        int[] array = new int[n + 1];
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i <= n; i++){
            for (int j = 1; j <= i; j++) {
                array[i] += (array[j - 1] * array[i - j]);//生成数的个数 跟元素 个数相关
            }
        }
        return array[n];
    }
}
