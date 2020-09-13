package algorithms.other.array;

import java.util.Arrays;

/**
 * 274. H 指数
 * Created by yangyuan on 2020/8/29.
 *
 * 给定一位研究者论文被引用次数的数组（被引用次数是非负整数）。编写一个方法，计算出研究者的 h 指数。

 h 指数的定义：h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。（其余的 N - h 篇论文每篇被引用次数 不超过 h 次。）

 例如：某人的 h 指数是 20，这表示他已发表的论文中，每篇被引用了至少 20 次的论文总共有 20 篇。


 */
public class HIndex {

    /**
     * 先排序 然后再判断
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int H = citations.length;
        for (int h = 0; h < citations.length; h++){
            if (citations[h] >= H - h) return H - h;
        }
        return 0;
    }
}
