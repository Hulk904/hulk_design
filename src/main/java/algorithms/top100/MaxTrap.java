package algorithms.top100;

/**
 * Created by yangyuan on 2020/1/1.
 */
public class MaxTrap {

    public static void main(String[] args) {
        int[] data = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(data));
    }

    public static int trap(int[] height){
        int leftMax = height[0], rightMax = height[height.length - 1];
        int left = 0, right = height.length - 1;
        int total = 0;
        while (left < right){
            if (height[left] < height[right]) {
                if (height[left] > leftMax){
                    leftMax = height[left];
                } else {
                    total += (leftMax - height[left]);
                }
                left++;
            } else{
                if (height[right] > rightMax){
                    rightMax = height[right];
                }else {
                    total += (rightMax - height[right]);
                }
                right--;
            }
        }
        return total;
    }
}
