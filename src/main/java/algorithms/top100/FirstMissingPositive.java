package algorithms.top100;

/**
 * Created by yangyuan on 2020/1/17.
 */
public class FirstMissingPositive {

    public static void main(String[] args) {
        int[] data = {1};
        System.out.println(firstMissingPositive(data));

    }

    public static int firstMissingPositive(int[] nums) {
        if (nums.length == 0){
            return 1;
        }
        for (int i = 0; i < nums.length; i++){
            while (nums[i] > 0 && nums[i] <nums.length && nums[i] != nums[nums[i] - 1]){
                    int temp = nums[i];
                    nums[i] = nums[nums[i] - 1];
                    nums[temp - 1] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++){
            if (i != nums[i] - 1){
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
