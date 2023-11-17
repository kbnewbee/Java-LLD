package main.java.policy;

public interface EvictPolicy<K> {

    void keyAccessed(K key);
    K evict();
}
