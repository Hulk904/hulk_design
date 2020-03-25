package algorithms.toutiao;

/**
 * Created by yangyuan on 2020/2/22.
 */
public class ValidUtf8 {

    public static void main(String[] args) {
        int[] data = {115,100,102,231,154,132,13,10};
        System.out.println(validUtf8(data));

    }

    public static boolean validUtf8(int[] data) {
        int mask = (1 << 8) - 1;
        for (int i = 0; i< data.length; i++){
            int curData = data[i] & mask;
            //one byte start with 0
            if ((curData >> 7 & 1 )==0){
                continue;
            }
            //two bytes
            if (curData >> 5 == 0b110){
                if (++i > data.length || ((data[i] & mask) >> 6) != 0b10){
                    return false;
                }
                continue;
            }
            //three bytes
            if (curData >> 4 == 0b1110){
                for (int j = 0; j <=1; j++) {
                    if (++i >= data.length || ((data[i] & mask) >> 6) != 0b10) {
                        return false;
                    }
                }
                continue;
            }
            if (curData >> 3 == 0b11110){
                for (int j = 0; j <=2; j++){
                    if (++i >= data.length || ((data[i] & mask) >> 6) != 0b10) {
                        return false;
                    }
                }
                continue;
            }
            return false;
        }
        return true;
    }

}
