package algorithms.other;

/**
 * Created by yangyuan on 2020/3/11.
 * 165. 比较版本号
 */
public class CompareVersion {
    public static void main(String[] args) {
        System.out.println(compareVersion("1.0.1", "1"));
    }
    public static int compareVersion(String version1, String version2) {
        String[] data1 = version1.split("\\.");
        String[] data2 = version2.split("\\.");
        int maxSize = Math.max(data1.length, data2.length);
        for(int i = 0; i < maxSize; i++){
            int a = i > (data1.length - 1)? 0 : Integer.parseInt(data1[i]);
            int b = i > (data2.length - 1)? 0 : Integer.parseInt(data2[i]);
            if (a > b){
                return 1;
            } else if (a < b){
                return -1;
            }
        }
        return 0;
    }

}
