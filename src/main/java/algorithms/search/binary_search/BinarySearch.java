package algorithms.search.binary_search;

/**
 * Created by yangyuan on 2020/2/29.
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] data = {0,1,3,4,5};
        System.out.println(bsearch(data, 2));
        System.out.println(bsearch2(data, 2));
        System.out.println(bsearch3(data, 2));
        System.out.println(bsearch4(data, 2));
    }

    /**
     *
     数据存在时正常，数据不存在时查询到的是大于target最小的那个
     bsearch_1(0,4,arr,2);
     这里寻找的是2， 元素不在数组里，则会找到从左往右数第一个 >= NumberToFind的元素位置，就是arr[2]
     bsearch_1(0,4,arr,-10);
     如果这里寻找-10,元素不在数组里，则会找到从左往右数第一个 >= NumberToFind的元素位置，就是arr[0]
     bsearch_1(0,4,arr,20);
     如果这里寻找20,元素不在数组里,会找到arr[4]
     * @param array
     * @param target
     * @return
     */
    private static int bsearch(int[] array ,int target){
        int l = 0, r = array.length - 1;
        while (l < r){
            int mid = l + r >> 1;
            if (array[mid] >= target ) r = mid;
            else l = mid + 1;
        }
        return l;
    }
    //数据存在是正常，数据不存在时查询到的是小于target的最大的那个
    private static int bsearch2(int[] array ,int target){
        int l = 0, r = array.length - 1;
        while (l < r){
            int mid = l + r + 1>> 1;
            if (array[mid] > target ) r = mid - 1;
            else l = mid ;
        }
        return l;
    }

    //则会找到第一个从右往左数 <= NumberToFind的元素位置!
    //和2 等效 存在正确，不存在，小于target最大的那个
    private static int bsearch3(int[] array, int target){
        int l = 0, r = array.length - 1;
        while (l < r){
            int mid = l + r + 1 >> 1;
            if (array[mid] <= target) l = mid;
            else r = mid -1;
        }
        return l;
    }
    // 这个和 1 等效
    private static int bsearch4(int[] array, int target){
        int l = 0, r = array.length - 1;
        while (l < r){
            int mid = l + r + 1 >> 1;
            if (array[mid] < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }

}
