package algorithms.other.btree;

import algorithms.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyuan on 2021/6/5.
 * 894. 所有可能的满二叉树
 * 满二叉树是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。

 返回包含 N 个结点的所有可能满二叉树的列表。 答案的每个元素都是一个可能树的根结点。

 答案中每个树的每个结点都必须有 node.val=0。

 你可以按任何顺序返回树的最终列表。

 */
public class AllPossibleFBT {
    public List<TreeNode> allPossibleFBT(int n) {
        if (n%2 == 0) return new ArrayList();
        List<TreeNode> res = new ArrayList();
        if (n == 1) res.add(new TreeNode());
        //分情况讨论
        //左子树 1个节点，右子树 n - 2 节点， 左子树3个节点，右子树n - 5个节点....
        for (int i = 1; i + 1 < n; i+=2){
            List<TreeNode> left = allPossibleFBT(i), right = allPossibleFBT(n - i - 1);
            for (TreeNode l:left){
                for (TreeNode r:right){
                    res.add(new TreeNode(0, l, r));
                }
            }
        }
        return res;
    }
}
