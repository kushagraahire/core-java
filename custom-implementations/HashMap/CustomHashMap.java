package HashMap;

import java.util.HashMap;
import java.util.Objects;

public class CustomHashMap<K, V> {

    private static class Node<K, V>{
        private final K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    private final float LOAD_FACTOR = 0.75f;
    //private int capacity;
    private int size;
    private Node<K,V>[] buckets;
    private final int INITIAL_SIZE = 1 << 4;
    private final int MAX_CAPACITY = 1 << 30;

    public CustomHashMap(){
        buckets = new Node[INITIAL_SIZE];
        size = 0;
    }

    @SuppressWarnings("unchecked")
    public CustomHashMap(int capacity){
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative");
        }
        int tableSize = tableSizeFor(capacity);
        buckets = new Node[tableSize];
        size = 0;
    }

    // Ensures table size is always a power of 2
    private int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16; // 32-bit int, so no >>> 32 needed
        return (n < 0) ? 1 : (n >= MAX_CAPACITY) ? MAX_CAPACITY : n + 1;
    }

    public void put(K key, V value){
        int hashcode = hash(key) & (buckets.length - 1);
        Node<K,V> node = buckets[hashcode];

        if(node == null){
            Node<K,V> newNode = new Node<>(key, value);
            buckets[hashcode] = newNode;
        }else{
            Node<K, V> current = node;
            Node<K, V> prev = null;

            while(current != null){
                if(Objects.equals(key, current.key)){
                    current.value = value;
                    return;
                }
                prev = current;
                current = current.next;
            }
            prev.next = new Node<>(key, value);
        }
        size++;

        if((float) size/ buckets.length > LOAD_FACTOR){
            resize();
        }
    }

    public void resize(){
        Node<K, V>[] oldBuckets = buckets;
        int newCapacity = oldBuckets.length * 2;
        if (newCapacity > MAX_CAPACITY) {
            newCapacity = MAX_CAPACITY;
        }


        Node<K, V>[] newBuckets = (Node<K, V>[]) new Node[newCapacity];
        buckets = newBuckets;

        for (Node<K, V> head : oldBuckets) {
            while (head != null) {
                Node<K, V> next = head.next;
                int newBucketIndex = hash(head.key) & (buckets.length - 1);
                head.next = newBuckets[newBucketIndex];
                newBuckets[newBucketIndex] = head;
                head = next;
            }
        }
    }

    public V get(K key){
        int hashcode = hash(key) & (buckets.length - 1);
        Node<K,V> node = buckets[hashcode];

        while(node != null){
            if(node.key.equals(key)){
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    public void remove(K key){
        int hashcode = hash(key) & (buckets.length - 1);
        Node<K, V> prev = null;
        Node<K, V> current = buckets[hashcode];

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    buckets[hashcode] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    private int hash(K key){
        if(key == null){
            return 0;
        }
        int hashcode = key.hashCode();
        return hashcode ^ hashcode >>> 16;
    }
}
