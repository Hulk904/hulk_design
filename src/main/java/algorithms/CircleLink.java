package algorithms;

/**
 * Created by yangyuan on 2018/9/3.
 * 第一步通过快慢指针找到相遇的节点（一定位于环内）
 * 第二步计算环的元素个数（从相遇节点往后走，并计数，重复则停止）
 * 根据环的个数来两个指针一个比另一个快上面的个数，  一直往后移，相同则 找到了。。。
 */
public class CircleLink {
    public static void main(String[] args) {

        Node one = new Node(1, null);
        Node two = new Node(2, one);
        Node three = new Node(3,two);
        one.setNext(three);
        Node four = new Node(4, three);
        Node five = new Node(5, four);
        Node six = new Node(6, five);
        Node seve = new Node(7, six);
        Node eight = new Node(8, seve);

        System.out.println(getEntry(eight));

    }

    private static Node getEntry(Node link){
        if(null == link){
            return null;
        }
        Node meet = getMeetNode(link);
        if(meet == null){
            return null;
        }
        int circleNodeNum = 1;
        Node p = meet.next;
        while(p != meet){
            circleNodeNum ++;
            p = p.next;
        }
        Node slow = link;
        Node fast = link;
        for(int i = 0; i < circleNodeNum; i ++){
            fast = fast.next;
        }
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    private static Node getMeetNode(Node link){
        if(link == null){
            return null;
        }
        Node p1 = link;
        Node p2 = link;
        do{
            p1 = p1.next;
            p2 = p2.next;
            if(p2 != null){
                p2 = p2.next;
            }else {
                return null;
            }
        }while(p1 != p2);
        return p1;
    }

    private static class Node {
        private Integer value;
        private Node next;

        public Node ( Integer value, Node next){
            this.value = value;
            this.next = next;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }
}
