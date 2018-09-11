package algorithms.search.bst;

/**
 * Created by yangyuan on 2018/4/19.
 */
public class Test {
    public static void main(String[] args) {
        BST<Integer,String> rank = new BST<Integer, String>();
        rank.put(4, "阳原");
        rank.put(5, "你么");
        rank.put(3, "恶风");
        rank.put(1, "打客服");
        rank.put(6, "分");
        System.out.println(rank.get(5));
        System.out.println(rank.get(9));
        int a = 5;
        System.out.println(a += 6 * 1.5);
    }
}
