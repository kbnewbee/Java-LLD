package main.java;

import main.java.cache.Cache;
import main.java.policy.LRUPolicy;
import main.java.storage.HashMapStorage;

public class App {

    public static void main(String[] args) {

        Cache<String, String> cache = new Cache<>(new LRUPolicy<>(), new HashMapStorage<>(3));

        cache.put("kallol", "jodhpur");
        cache.put("swapnil", "jodhpur");
        cache.put("mridul","delhi");
        cache.put("bunny","noida");
        cache.put("chotsa","noida");
        cache.put("mansa","jaipur");

    }
}
