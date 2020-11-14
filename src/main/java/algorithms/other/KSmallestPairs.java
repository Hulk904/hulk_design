package algorithms.other;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by yangyuan on 2020/9/26.
 *
 * 373. 查找和最小的K对数字
 *
 * 给定两个以升序排列的整形数组 nums1 和 nums2, 以及一个整数 k。

 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2。

 找到和最小的 k 对数字 (u1,v1), (u2,v2) ... (uk,vk)。

 */
public class KSmallestPairs {

    //考察多路归并
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0 || nums2.length == 0) return new ArrayList<>();
        int n = nums1.length, m = nums2.length;
        PriorityQueue<int[]>  queue = new PriorityQueue<int[]>((o1, o2) -> o1[0] - o2[0]);
        for (int i = 0 ;i < m; i++){
            queue.add(new int[]{nums2[i] + nums1[0], 0, i});
        }
        //
        List<List<Integer>> res = new ArrayList<>();
        while (k-- > 0 && !queue.isEmpty()){
            int[] t = queue.poll();
            res.add(new ArrayList<Integer>(){{add(nums1[t[1]]);add(nums2[t[2]]);}});
            if (t[1] + 1 < n){
                queue.add(new int[]{nums1[t[1]  +1] + nums2[t[2]], t[1] + 1, t[2]});
            }
        }
        return res;
    }
}
