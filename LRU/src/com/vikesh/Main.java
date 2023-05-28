package com.vikesh;

import java.util.Scanner;

public class Main {

    /*
    Implement the LRUCache class:

    LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
    int get(int key) Return the value of the key if the key exists, otherwise return -1.
    void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
    The functions get and put must each run in O(1) average time complexity
     */
    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        LRUCache lruCache = new LRUCache(2);
        while (true) {
            System.out.println("what operation you want: -->" +
                    " 1.get Key" +
                    " 2.set key" +
                    " 3.delete key" +
                    " 4.clean LRU" +
                    " 5. queue size" +
                    " 6. Print LRU");
            int opertion = scanner.nextInt();
            int key, value;
            switch (opertion) {
                case 1:
                    System.out.println("input key:");
                    key = scanner.nextInt();
                    System.out.println(lruCache.getValue(key));
                    break;
                case 2:
                    System.out.println("input key and value:");
                    key = scanner.nextInt();
                    value = scanner.nextInt();
                    lruCache.setKeyValue(key, value);
                    break;
                case 3:
                    System.out.println("enter key");
                    key = scanner.nextInt();
                    lruCache.deleteKey(key);
                    break;
                case 4:
                    lruCache.clean();
                    break;
                case 5:
                    System.out.println(lruCache.queueSize()); break;
                case 6:
                    lruCache.printLRU();
                    break;
                default:
                    System.out.println("wrong input");
            }
        }
    }
}
