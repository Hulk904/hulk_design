package algorithms.other.array;

/**
 * Created by yangyuan on 2021/11/22.
 * 1010. 总持续时间可被 60 整除的歌曲
 * 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。

 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，我们希望索引的数字 i 和 j
 满足  i < j 且有 (time[i] + time[j]) % 60 == 0。

 */
public class NumPairsDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] time) {
        int[] s = new int[60];
        int res = 0;
        for (int i:time){
            res += s[(60 - i%60)%60];//最后一个%60 特殊处理0
            s[i%60]++;
        }
        return res;
    }
}
