package pattern_design.iterator;

import java.util.Vector;

/**
 * Created by yangyuan on 2018/3/23.
 */
public class ConcretIterator implements Iterator{

    private Vector vector = new Vector();

    private int cursor = 0;

    public ConcretIterator(Vector vector){
        this.vector = vector;
    }

    public Object next() {
        if(hasNext()) {
            return vector.get(cursor++);
        }
        return null;
    }

    public boolean hasNext() {
        if(cursor >= vector.size() || vector.get(cursor) == null) {
            return false;
        }
        return true;
    }

    public boolean remove() {
         vector.remove(cursor);
        return true;
    }
}
