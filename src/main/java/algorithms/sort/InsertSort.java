package algorithms.sort;

import java.util.Random;

/**
 * Created by yangyuan on 2018/3/31.
 */
public class InsertSort extends SortTemplate{
    public void sort(Comparable[] a) {
        for(int i = 0; i < a.length; i++){
            for(int j = i; j > 0 && less(a[j],a[j - 1]) ; j--){
                exch(a, j, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] list = new Integer[20];
        Random random = new Random(100);
        for(int i = 0; i < 20; i++){
            list[i] = random.nextInt(100);
        }
        new InsertSort().sort(list);
        SortTemplate.show(list);
    }
}
