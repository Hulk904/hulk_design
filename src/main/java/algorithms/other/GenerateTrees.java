package algorithms.other;

import algorithms.ListNode;
import algorithms.TreeNode;
import com.alibaba.fastjson.JSON;
import com.sun.tools.javac.jvm.Gen;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyuan on 2020/3/3.
 * 95. 不同的二叉搜索树 II
 *
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 * 类似 96
 */
public class GenerateTrees {

    public static void main(String[] args) {
        GenerateTrees g = new GenerateTrees();
        System.out.println(JSON.toJSONString(g.generateTrees(3)));
    }

    public List<TreeNode> generateTrees(int n) {
        return dfs(1,n );
    }

    /**
     *
     * @param l 左子树开始位置
     * @param r 右子树开始位置
     * @return
     */
    List<TreeNode> dfs (int l, int r){
        List<TreeNode> res = new ArrayList<>();
        if (l > r){//注意如果是不存在 要返回带一个null的集合
            res.add(null);
            return res;
        }
        for (int i = l; i <= r; i++){
            List<TreeNode> left = dfs(l, i - 1);
            List<TreeNode> right = dfs(i + 1, r);
            for (int m = 0; m < left.size(); m++){
                for (int n = 0; n < right.size(); n++){
                    //i 为根节点
                    TreeNode root = new TreeNode(i);
                    root.left = left.get(m);
                    root.right = right.get(n);
                    res.add(root);//最终拼出来的结果放在res中
                }
            }
        }
        return res;
    }

}
