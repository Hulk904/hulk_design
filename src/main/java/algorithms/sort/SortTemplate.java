package algorithms.sort;


/**
 * Created by yangyuan on 2018/3/31.
 */
public abstract class SortTemplate {
    public abstract void sort(Comparable[] a);

    public boolean less(Comparable a,Comparable b){
        return a.compareTo(b) < 0;
    }

    public void exch(Comparable[] a,int i ,int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable [] a){
        for(int i = 0; i < a.length; i++){
            System.out.println(a[i]);

        }
    }

}
