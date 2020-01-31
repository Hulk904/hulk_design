package algorithms.top100;

/**
 * Created by yangyuan on 2020/1/9.
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] data = {3,2,3};
        System.out.println(majorityElement(data));
    }

    public static int majorityElement(int[] nums) {
        int curNum = nums[0];
        int totla = 1;
        for (int i = 1; i < nums.length; i++){
            if (totla == 0){
                curNum = nums[i];
            }
            if (nums[i] == curNum){
                totla++;
                continue;
            }
            totla--;
        }
        return curNum;
    }
}
