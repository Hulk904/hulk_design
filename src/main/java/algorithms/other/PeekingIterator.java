package algorithms.other;

import java.util.Iterator;

/**
 * Created by yangyuan on 2020/8/30.
 * 284. 顶端迭代器
 *
 * 给定一个迭代器类的接口，接口包含两个方法： next() 和 hasNext()。设计并实现一个支持 peek() 操作的顶端迭代器 -- 其本质就是把原本应由 next() 方法返回的元素 peek() 出来。

 */

/**
 * 使用一个缓存记录下元素
 */
public class PeekingIterator implements Iterator<Integer> {

    boolean hasNext;

    /**
     * 当前元素，但是未返回的
     */
    Integer cur;

    Iterator<Integer> iterator;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        if (iterator.hasNext()){
            hasNext = true;
            cur = iterator.next();
        } else {
            hasNext = false;
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return  cur;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int t = cur;
        hasNext = iterator.hasNext();
        if (hasNext){
            cur = iterator.next();
        }
        return t;
    }

    @Override
    public boolean hasNext() {
        return hasNext;
    }
}
