import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by yangyuan on 2018/3/20.
 */
public class Test {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("124", "234");
        System.out.println(map.get("124"));
        System.out.println(map.get("333"));
    }

    static float sqr(float x){
        float max = x < 1 ? 1 : x;
        float min = 0;
        float mid=(min+max)/2;
        while (true){
            if (Math.abs(x-mid*mid)<0.002) return mid;

            if(mid*mid>x)
            {
                max=mid;
            }
            else if(mid*mid<x)
            {
                min=mid;
            }

            mid=(min+max)/2;
        }


    }
}
