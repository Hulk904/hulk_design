package algorithms.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyuan on 2020/7/19.
 * 119. 杨辉三角 II
 *
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 */
public class GetRow2 {

    /**
     * 滚动数组使得 空间为 o(k)
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++){
            res = new ArrayList();
            for (int j = 0; j <= i; j++){
                if (j == 0 || j == i){
                    res.add(1);
                    continue;
                }
                res.add(pre.get(j - 1) + pre.get(j));
            }
            pre = res;
        }
        return res;
    }

    //一个数组
    public List<Integer> getRow2(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        for (int i = 0; i <= rowIndex; i++){
            res.add(1);
            for (int j = i; j > 1; j--){
                res.set(j - 1, res.get(j - 1)+ res.get(j - 2));
            }
        }
        return res;
    }
}
