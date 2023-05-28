package com.vikesh;

import java.util.*;
import java.util.stream.Collectors;

public class LRUCache {
    private final int capacity;
    private final Deque<Integer> q = new LinkedList<>();
    private final Map<Integer, Integer> map = new HashMap<>();

    LRUCache(int capacity) {
        this.capacity = capacity;
    }
    public int getValue(int key) {
        /*
        * return if key not present
        * if present first remove element from deque and then insert in deque and return value
        * */
        if(!map.containsKey(key)) {
            System.out.println("not found");
            return -1;
        }
        q.remove(key);
        q.add(key);
        return map.get(key);
    }

    public void setKeyValue(int key, int value) {
        /*
        * check if element already present -> (yes) --> remove element from q update in map and add in q
        * if(capacity == q.size() --> (yes) -> remove first element from q and map then insert
        * else insert
        * */

        if(map.containsKey(key)) {
            q.remove(key);
        } else if(capacity ==  q.size() && capacity != 0) {
            int firstElement = q.removeFirst();
            map.remove(firstElement);
        }
        insert(key, value);
    }

    private void insert(int key, int value) {
        map.put(key, value);
        q.add(key);
    }

    public void clean() {
        q.clear();
        map.clear();
    }

    public void deleteKey(int key) {
        if(map.containsKey(key)) {
            q.remove(key);
            map.remove(key);
        }
    }

    public int queueSize() {
        return q.size();
    }
    public void printLRU() {
        System.out.println(q.stream().map(Object::toString).collect(Collectors.toList()));
        System.out.println(map.toString());
    }
}
