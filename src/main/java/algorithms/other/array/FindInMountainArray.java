package algorithms.other.array;

/**
 * Created by yangyuan on 2022/1/2.
 * 1095. 山脉数组中查找目标值
 *
 * 给你一个 山脉数组 mountainArr，请你返回能够使得 mountainArr.get(index) 等于 target 最小 的下标 index 值。

 如果不存在这样的下标 index，就请返回 -1。

 */
public class FindInMountainArray {

    //两次二分
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int l = 0, r = n - 1;
        while (l < r){
            int mid = l + r >> 1;
            if (mountainArr.get(mid) > mountainArr.get(mid + 1)) r = mid;
            else l = mid + 1;
        }
        int M = r;
        l = 0; r = M;
        while (l < r){
            int mid = l + r >> 1;
            if (mountainArr.get(mid) >= target) r = mid;
            else l = mid + 1;
        }
        if (mountainArr.get(r) == target) return r;
        l = M + 1;
        r = n - 1;
        while (l < r){
            int mid = l + r >> 1;
            if (mountainArr.get(mid) <= target) r = mid;
            else l = mid + 1;
        }
        if (mountainArr.get(r) == target) return r;
        return -1;
    }
}
 interface MountainArray {
        public int get(int index) ;
        public int length() ;
 }