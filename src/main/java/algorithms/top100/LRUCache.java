package algorithms.top100;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by yangyuan on 2020/1/8.
 */
public class LRUCache extends LinkedHashMap{

    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer data = (Integer) super.get(key);
        if (data == null){
            return -1;
        }
        return data; //super.getOrDefault(key, -1)
    }

    public void put(int key, int value) {
       super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size()>capacity;
    }
}
