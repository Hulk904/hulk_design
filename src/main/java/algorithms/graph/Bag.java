package algorithms.graph;

import java.util.*;

/**
 * Created by yangyuan on 2020/1/17.
 */
public class Bag<T> implements Iterable<T> {

    private Set<T> data;

    @Override
    public Iterator<T> iterator() {
        return data.iterator();
    }

    public Bag(){
        data = new HashSet<T>();
    }

    public void add(T item){
        data.add(item);
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    public int size(){
        return data.size();
    }
}
