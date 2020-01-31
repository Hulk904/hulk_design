package algorithms.top100;

/**
 * Created by yangyuan on 2020/1/26.
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

 你可以假设 nums1 和 nums2 不会同时为空。

 中位数：两边数据 个数相同
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] data1 = {};
        int[] data2 = {3};
        System.out.println(findMedianSortedArrays(data1, data2));

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        int amin = 0, amax = m;
        int halfLen = (m + n + 1)/2;
        while (amin <= amax){
            int i = (amin + amax)/2;
            int j = halfLen - i;
            if (i < amax && nums1[i] < nums2[j - 1]) {
                amin = i + 1; //二分查找
            } else if (amin < i && nums1[i - 1] > nums2[j]){
                amax = i - 1;
            } else {
                int maxLeft = 0;
                if (i == 0){
                    maxLeft = nums2[j - 1];
                } else if (j == 0){
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i -1], nums2[j - 1]);
                }
                if ((m + n)%2 == 1){
                    return maxLeft;
                }
                int minRight = 0;
                if (i == m){
                    minRight = nums2[j];
                } else if (j == n){
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }
                return (maxLeft  + minRight)/ 2.0;
            }
        }
        return 0.0;
    }


}
