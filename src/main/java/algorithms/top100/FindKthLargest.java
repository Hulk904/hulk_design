package algorithms.top100;

/**
 * Created by yangyuan on 2020/1/10.
 *
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

 示例 1:

 输入: [3,2,1,5,6,4] 和 k = 2
 输出: 5

 */
public class FindKthLargest {

    public static void main(String[] args) {
        int[] data = {3,2,1,5,6,4};
        System.out.println(findKthLargest(data, 2));

        FindKthLargest k = new FindKthLargest();
        System.out.println(k.findKthLargest2(data, data.length - 1));

    }


    /**
     * 因为是找到第k大的数据
     * 如果排序为生序，则 第k大的数据的坐标应该是 数组长度-k
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        int left = 0;
        int target = nums.length - k ; //注意  是找到第k大的数据
        int right = nums.length - 1;
        while (true) {
            int pirot = partition(nums, left, right);
            if (pirot == target) {
                return nums[pirot];
            } else if (pirot < target) {
                left = ++pirot; //注意
            } else {
                right = --pirot;//注意
            }
        }
    }

    private static int partition(int[]array, int left, int right){
        int pirotKey = array[left];
        while (left < right){
            while (left < right && array[right] >= pirotKey){
                right --;
            }
            array[left] = array[right];
            while (left < right && array[left] <= pirotKey){
                left ++;
            }
            array[right] = array[left];
        }
        array[left] = pirotKey;
        return left;
    }


    int[] q;

    public  int findKthLargest2(int[] nums, int k) {
        this.q = nums;
        return quickSort(0, nums.length - 1, k);
    }

    int quickSort(int l, int r, int k){
        if (l == r) return q[l];
        int x = q[l], i = l - 1, j = r + 1;
        while (i < j){
            while (q[++i] < x);
            while (q[--j] > x);
            if (i < j){
                int temp = q[i];
                q[i] = q[j];
                q[j] = temp;
            }
        }
        int sl = j - l + 1;
        if (k <= sl) return quickSort(l, j, k);
        return quickSort(j + 1, r, k - sl);//右区间 的 k-sl 小的数
    }


    public int findKthLargest3(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, k - 1);
    }

    int quickSort(int[] nums, int l, int r, int k){
        if (l == r) return nums[k];
        int x = nums[l], i = l - 1, j = r + 1;
        while (i < j){
            do i++;
            while (nums[i] > x);
            do j--;
            while (nums[j] < x);
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        if (k <= j) return quickSort(nums, l , j, k);
        else return quickSort(nums, j + 1, r, k);
    }


    /**
     * 按自己比较熟悉的快排方式实现
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest4(int[] nums, int k) {
        return partition3(nums, 0, nums.length - 1, nums.length - k);
    }

    int partition3(int[] nums, int left, int right, int k){
        if (left >= right) return nums[k];
        int l = left, r = right;
        int pirot = nums[left];
        while (left < right){
            while (left < right && nums[right] >= pirot) right--;
            nums[left] = nums[right];
            while (left < right && nums[left] <= pirot) left++;
            nums[right] = nums[left];
        }
        nums[left] = pirot;
        if (left < k) return partition3(nums, left + 1, r, k);
        else return  partition3(nums, l, left, k);
    }

}
