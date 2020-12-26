package algorithms.other;

/**
 * Created by yangyuan on 2020/11/28.
 * 547. 朋友圈
 *
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，
 * B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。

 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和
 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。

 */
public class FindCircleNum {

    int[] p;

    //查找
    int find(int x){
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    public int findCircleNum(int[][] M) {
        int n = M.length;
        p = new int[n];
        for (int i = 0; i < n; i++){
            p[i] = i;
        }
        int cnt = n;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (M[i][j] > 0 && find(i) != find(j)){
                    //合并
                    p[find(i)] = find(j);
                    cnt--;
                }
            }
        }
        return cnt;
    }
}
