package algorithms.toutiao;

/**
 * Created by yangyuan on 2020/2/19.
 */
public class Rand10 {


    public int rand10Two() {
        int a ,b, t;
        do {
            a = rand7();
            b = rand7();
            t = a + (b-1)*7;
        } while (t > 40);
        return 1 + (t - 1)%10;
    }

    public int rand10() {
        int a = rand7();
        int b = rand7();
        while (a == 7){
            a = rand7();
        }
        while (b > 5){
            b = rand7();
        }
        return((a&1) == 1 ? 0 : 5) + b;// 1/2的概率产生 0 或 5， 1/5的概率产生1、2、3、4、5
    }

    private int rand7(){
        return 0;
    }
}
