package pattern_design.iterator;

/**
 * Created by yangyuan on 2018/3/23.
 */
public interface Aggregate {
    void add(Object object);
    void remove(Object object);
    Iterator iterator();
}
