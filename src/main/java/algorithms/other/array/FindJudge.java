package algorithms.other.array;

 /**
 * Created by yangyuan on 2021/11/14.
  * 997. 找到小镇的法官
  *
  * 在一个小镇里，按从 1 到 n 为 n 个人进行编号。传言称，这些人中有一个是小镇上的秘密法官。

  如果小镇的法官真的存在，那么：

  小镇的法官不相信任何人。
  每个人（除了小镇法官外）都信任小镇的法官。
  只有一个人同时满足条件 1 和条件 2 。
  给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示编号为 a 的人信任编号为 b 的人。

  如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的编号。否则，返回 -1。

 */
public class FindJudge {
     public int findJudge(int n, int[][] trust) {
         int[] din = new int[n + 1], dout = new int[n + 1];
         //直接模拟
         for (int[] p:trust){
             int a = p[0], b = p[1];
             din[b]++;
             dout[a]++;
         }
         int res = -1;
         for (int i = 1; i<=n; i++){
             if (dout[i] == 0 && din[i] == n - 1){//法官的条件：出度为 0， 入度为 n-1
                 if (res != -1) return -1;//有多个
                 res = i;
             }
         }
         return res;
     }
}
