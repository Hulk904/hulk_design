package algorithms.sort;

import java.util.Random;

/**
 * Created by yangyuan on 2018/4/7.
 */
public class HeapSort extends SortTemplate{
    public void sort(Comparable[] a) {
        int N = a.length;
        for ( int k = N/2; k >= 1; k--){
            sink(a, k, N);
        }
        while(N > 1){
            exch(a, 1, N--);
            sink(a, 1, N);
        }
    }
    private void sink(Comparable[] a, int k, int N){
        while(2*k <= N){
            int j = 2*k;
            if(j < N && less(j, j+1)) j++;
            if(!less(k, j)) break;
            exch(a, k ,j);
            k = j;
        }
    }

    public static void main(String[] args) {
        Integer[] list = new Integer[20];
        Random random = new Random(100);
        for(int i = 0; i < 20; i++){
            list[i] = random.nextInt(100);
        }
        new HeapSort().sort(list);
        SortTemplate.show(list);
    }
}
