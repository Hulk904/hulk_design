package pattern_design.iterator;

import java.util.Vector;

/**
 * Created by yangyuan on 2018/3/23.
 */
public class ConcreteAggregate implements Aggregate{

    private Vector vector;

    public ConcreteAggregate(Vector vector){
        this.vector = vector;
    }

    public void add(Object object) {
        vector.add(object);
    }

    public void remove(Object object) {
        vector.remove(object);
    }

    public Iterator iterator() {
        return new ConcretIterator(this.vector);
    }
}
