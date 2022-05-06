package algorithms.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by yangyuan on 2022/1/2.
 * 1104. 二叉树寻路
 * 在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记。

 如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；

 而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。

 给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，该路径是由途经的节点标号所组成的。
 */
public class PathInZigZagTree {

    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> res = new ArrayList<>();
        while (label > 0) {//没有翻转情况下的路径
            res.add(label);
            label >>= 1;
        }
        Collections.reverse(res);
        for (int i = res.size()%2; i<res.size(); i+= 2){//是否翻转取决于是在奇数层还是偶数层
            res.set(i, res.get(i)^((1<<i) - 1));//元素翻转  首位不变，其他位取反
        }
        return res;
    }
}
