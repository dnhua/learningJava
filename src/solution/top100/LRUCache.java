package solution.top100;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 146. LRU Cache
 * https://leetcode.com/problems/lru-cache/submissions/
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the
 * following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise
 * return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its
 * capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * The cache is initialized with a positive capacity.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 */
public class LRUCache {
    //链表加HashMap实现
    private int capacity, num;  //capacity为容量，num为当前装的数量
    private List<Integer> list;
    private Map<Integer, Integer> map;
    public LRUCache(int capacity) {
        num = 0;
        this.capacity = capacity;
        list = new LinkedList<>();
        map = new HashMap<>();
    }

    public int get(int key) {
        //首先看map里面有没有，没有的话直接返回-1；有的话在进行以下操作
        if (map.containsKey(key)) {
            Integer ret = map.get(key);
            list.remove((Integer) key);
            list.add(key);
            return ret;
        }
        return -1;
    }

    public void put(int key, int value) {
        //put的话也同样需要看有没有
        if (map.containsKey(key)) {
            list.remove((Integer) key);
            map.put(key, value);
            list.add(key);
        } else {
            //如果过量了
            if (num == capacity) {
                map.remove(list.get(0));
                Integer removed = list.remove((int) 0);
                list.add((Integer) key);
                map.put(key, value);
            } else {
                map.put(key,value);
                list.add(key);
                num++;
            }
        }
    }
}
