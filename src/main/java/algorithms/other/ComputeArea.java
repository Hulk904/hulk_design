package algorithms.other;

/**
 * Created by yangyuan on 2020/3/1.
 *
 * 1、判断两个矩形是否有交集
 * 2、是否有交集可以通过水平和垂直两个方向判断，
 * 两个区间是否有交集可以通过公式
 *
 * 区间（A，B） （C，D）
 * l = min（B,D） - max(A,C). l小于0则 没有交集
 */
public class ComputeArea {


    /**
     * 注意越界
     * @param A
     * @param B
     * @param C
     * @param D
     * @param E
     * @param F
     * @param G
     * @param H
     * @return
     */
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        long x = (long)Math.min(D, H) - Math.max(B, F);
        long y = (long)Math.min(C, G) - Math.max(A, E);
        long allArea = ((long)D - B)*((long)C - A) + ((long)H - F)*((long)G - E);
        return (int)((x <= 0 || y <= 0) ? allArea : allArea - x*y);
    }
}
