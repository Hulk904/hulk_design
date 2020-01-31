package algorithms.top100;

/**
 * Created by yangyuan on 2019/12/28.
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai)
 * 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水
 */
public class MaxArea {

    public static void main(String[] args) {
        int[] array = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(array));
    }

    private static int maxArea(int[] array){
        if (array.length <=1){
            return 0;
        }
        int i = 0, j = array.length - 1;
        int maxArea = 0;
        while (i < j){
            int temp = Math.min(array[i],array[j]);
            maxArea = Math.max(maxArea, temp*(j-i));
            if (array[i] > array[j]){
                j--;
            } else {
                i++;
            }
        }
        return maxArea;
    }
}
