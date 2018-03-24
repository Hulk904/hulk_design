package pattern_design.iterator;

/**
 * Created by yangyuan on 2018/3/23.
 */
public interface Iterator {
    Object next();
    boolean hasNext();
    boolean remove();
}
