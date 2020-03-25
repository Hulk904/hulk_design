package algorithms.toutiao;

import java.util.Arrays;

/**
 * Created by yangyuan on 2020/2/23.
 * 1101
 *
 * 在一个社交圈子当中，有 N 个人。每个人都有一个从 0 到 N-1 唯一的 id 编号。

 我们有一份日志列表 logs，其中每条记录都包含一个非负整数的时间戳，以及分属两个人的不同 id，logs[i] = [timestamp, id_A, id_B]。

 每条日志标识出两个人成为好友的时间，友谊是相互的：如果 A 和 B 是好友，那么 B 和 A 也是好友。

 如果 A 是 B 的好友，或者 A 是 B 的好友的好友，那么就可以认为 A 也与 B 熟识。

 返回圈子里所有人之间都熟识的最早时间。如果找不到最早时间，就返回 -1 。

  

 示例：

 输入：logs = [[20190101,0,1],[20190104,3,4],[20190107,2,3],[20190211,1,5],[20190224,2,4],[20190301,0,3],[20190312,1,2],[20190322,4,5]], N = 6
 输出：20190301
 解释：
 第一次结交发生在 timestamp = 20190101，0 和 1 成为好友，社交朋友圈如下 [0,1], [2], [3], [4], [5]。
 第二次结交发生在 timestamp = 20190104，3 和 4 成为好友，社交朋友圈如下 [0,1], [2], [3,4], [5].
 第三次结交发生在 timestamp = 20190107，2 和 3 成为好友，社交朋友圈如下 [0,1], [2,3,4], [5].
 第四次结交发生在 timestamp = 20190211，1 和 5 成为好友，社交朋友圈如下 [0,1,5], [2,3,4].
 第五次结交发生在 timestamp = 20190224，2 和 4 已经是好友了。
 第六次结交发生在 timestamp = 20190301，0 和 3 成为好友，大家都互相熟识了。


 注意理解题意： 所有人都认识的时间点 如果是个图的话就是所有节点都连接上了
 */
public class EarliestAcq {

    int[] parent;

    public static void main(String[] args) {
        EarliestAcq earliestAcq = new EarliestAcq();
        int[][] data = {{20190101,0,1},{20190104,3,4},{20190107,2,3},{20190211,1,5},
                {20190224,2,4},{20190301,0,3},{20190312,1,2},{20190322,4,5}};
        System.out.println(earliestAcq.earliestAcq(data, 6));
    }

    public int earliestAcq(int[][] logs, int N) {
        parent = new int[N];
        for (int i = 0; i < N; i++){
            parent[i] = i;
        }
        Arrays.sort(logs, (a,b) -> a[0] - b[0]);
        int res = 0;
        for (int i = 0; i < logs.length; i++){
            if (find(logs[i][1]) != find(logs[i][2])){
                res = logs[i][0];
                uninon(logs[i][1 ], logs[i][2]);
            }
        }
        int roots = 0;
        for (int i = 0; i < N; i++){
            if (parent[i] == i){
                roots++;
            }
        }
        return roots > 1 ? -1 : res;
    }

    //合并时是 parent指向另一个的pareng  ，而不是直接 p指向q 或者反之的逻辑。。。
    public void uninon (int p , int q){
        int pp = find(p);
        int qp = find(q);
        parent[pp] = qp;
    }

    public int find(int p){
        while (parent[p] != p){
            p = parent[p];
        }
        return p;
    }
}
