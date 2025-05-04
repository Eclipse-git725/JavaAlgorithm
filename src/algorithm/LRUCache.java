package algorithm;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 文件名称: Algorithm4.java
 * 作者: gxy
 * 创建日期: 2025/4/21
 * 描述: 手撕LRU缓存
 */
class LRUCache {
    private final int capacity;
    private final Map<Integer, Integer> cache = new LinkedHashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer value = cache.remove(key);
        if(value != null) {
            // get之后要放到最上面
            cache.put(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        // put前要先删除key，判断key是否已经在cache
        if(cache.remove(key) != null) {
            cache.put(key, value);
            return;
        }

        // key不在cache，判断cache是否满，再插入
        if(cache.size() == capacity) {
            Integer eldestKey = cache.keySet().iterator().next(); // 获取第一个插入的元素
            cache.remove(eldestKey);
        }
        cache.put(key, value);
    }
}

