package main.java.policy;

import main.java.structure.DLLNode;
import main.java.structure.DLLQueue;

import java.util.HashMap;
import java.util.Map;

public class LRUPolicy<K> implements EvictPolicy<K> {

    private DLLQueue<K> dataQueue;
    private Map<K, DLLNode<K>> keyToNodeMap;

    public LRUPolicy() {
        this.dataQueue = new DLLQueue<>();
        keyToNodeMap = new HashMap<>();
    }

    @Override
    public void keyAccessed(K key) {
        // move the key to last mode i.e. most recently used
        if (keyToNodeMap.containsKey(key)) {
            DLLNode<K> node = keyToNodeMap.get(key);
            dataQueue.detachNode(node);
            dataQueue.insertNode(node);
        }else {
            DLLNode<K> node = new DLLNode<>(key);
            dataQueue.insertNode(node);
            keyToNodeMap.put(key, node);
        }
    }

    @Override
    public K evict() {

        // remove the first node i.e. oldest node
        DLLNode<K> oldestNode = dataQueue.getFirstNode();
        if (oldestNode == null) return null;

        dataQueue.detachNode(oldestNode);
        return oldestNode.getData();
    }
}
