package algorithms.other;

/**
 * Created by yangyuan on 2021/3/28.
 * 765. 情侣牵手
 * N 对情侣坐在连续排列的 2N 个座位上，想要牵到对方的手。 计算最少交换座位的次数，以便每对情侣可以并肩坐在一起。 一次交换可选择任意两人，让他们站起来交换座位。

 人和座位用 0 到 2N-1 的整数表示，情侣们按顺序编号，第一对是 (0, 1)，第二对是 (2, 3)，以此类推，最后一对是 (2N-2, 2N-1)。

 这些情侣的初始座位  row[i] 是由最初始坐在第 i 个座位上的人决定的。

 */
public class MinSwapsCouples {
    int[] p;
    public int minSwapsCouples(int[] row) {
        int n = (row.length)/2;
        p = new int[n];
        for (int i = 0; i < n; i++) p[i] = i;
        int cnt = n;
        for (int i = 0; i < n*2; i+=2){
            int a = row[i]/2;
            int b = row[i+1]/2;
            if (find(a) != find(b)){
                p[find(a)] = p[find(b)];
                cnt--;
            }
        }
        return n - cnt;
    }
    int find(int x){
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    public static void main(String[] args) {
        int[] row = new int[]{0,2,1,3};
       new  MinSwapsCouples().minSwapsCouples(row);
    }
}
