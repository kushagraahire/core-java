package LRUCache;

import java.util.HashMap;

public class LRUCache {
    class Node {
        private int key;
        private int value;
        private Node next;
        private Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private HashMap<Integer, Node> map;
    private int size;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
        size = 0;
    }

    public int get(int key) {
        Node node = map.get(key);
        int value = -1;
        if(node != null){
            value = node.value;
            removeNode(node);
            addStart(node);
        }
        return value;
    }

    private void addStart(Node node) {
        Node next = head.next;
        head.next = node;
        node.next = next;
        next.prev = node;
        node.prev = head;
    }

    private void removeNode(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            if(size == capacity){
                map.remove(tail.prev.key);
                removeNode(tail.prev);
                size--;
            }
            Node newNode = new Node(key, value);
            addStart(newNode);
            map.put(key, newNode);
            size++;
        } else {
            node.value = value;
            removeNode(node);
            addStart(node);
        }
    }
}
