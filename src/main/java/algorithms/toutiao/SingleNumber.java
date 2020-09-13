package algorithms.toutiao;

/**
 * Created by yangyuan on 2020/4/11.
 * 260. 只出现一次的数字 III
 *给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 */
public class SingleNumber {

    public static void main(String[] args) {
        int a  =13;
        System.out.println(Integer.highestOneBit(a));
        System.out.println(a & (-a));
    }


    public int[] singleNumber(int[] nums) {
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++){
            temp = temp ^ nums[i];
        }
        int lastBit = temp & (-temp);
        int one = 0, two = 0;
        //通过lastbit 把数组分为两组
        for (int i = 0; i < nums.length; i++){
            if ((nums[i] & lastBit) == 0){
                one = one ^ nums[i];
            } else {
                two = two ^ nums[i];
            }
        }
        return new int[]{one, two};//其实 two = one ^ temp;
    }
}
