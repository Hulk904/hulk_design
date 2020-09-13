package algorithms.acwing;

/**
 * Created by yangyuan on 2020/4/10.
 */
public class Test1 {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        System.out.println(reverse("三千四百五十二万零九百九十九"));
    }

    public static  int reverse(String source){
        int res = 0;
        int cur = 0;
        for (int i = 0; i < source.length(); i++){
            char t = source.charAt(i);
            if (t == '零') continue;
            Integer times= mapTimes(t);
            if (times == null){
                cur = numTrans(t);
                if (i == source.length() - 1){
                    res += cur;
                }
                //res += cur;
            } else {
                //times
                if (times == 10000){
                    res += cur;
                    res = res*times;
                } else {
                    res += cur*times;
                }

            }
        }
        return res;
    }

    private static int numTrans(char c){
        if (c == '九'){
            return 9;
        }else if (c == '八'){
            return 8;
        } else if (c == '七'){
            return 7;
        } else if (c == '六'){
            return 6;
        } else if (c == '五'){
            return 5;
        } else if (c == '四'){
            return 4;
        } else if (c == '三'){
            return 3;
        } else if (c == '二'){
            return 2;
        } else if (c == '一'){
            return 1;
        }
        return -1;
    }

    private static Integer mapTimes (char c){
        if (c == '万'){
            return 10000;
        } else if (c == '千'){
            return 1000;
        } else if (c == '百'){
            return 100;
        } else if (c == '十'){
            return 10;
        }
        return null;
    }


}