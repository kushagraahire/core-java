package LinkedList;

import ArrayList.CustomArrayList;

public class CustomLinkedList {
    class ListNode{
        private int value;
        private ListNode next;

        public ListNode(int value){
            this.value = value;
        }
    }

    private ListNode head;
    private ListNode tail;
    private int size;

    public CustomLinkedList(){
    }

    public void addFirst(int value){
        ListNode node = new ListNode(value);
        size++;
        if(head == null){
            head = node;
            tail = head;
            return;
        }
        node.next = head;
        head = node;
    }

    public void addLast(int value){
        ListNode node = new ListNode(value);
        size++;
        if(head == null){
            head = node;
            tail = head;
            return;
        }
        tail.next = node;
        tail = node;
    }

    public void print(){
        ListNode node = head;
        while(node != null){
            System.out.println("["+node.value+"]");
            node = node.next;
        }
    }

    public int getSize(){
        return size;
    }

    public void add(int index, int value){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Invalid Index");
        }
        if(index == 0){
            addFirst(value);
            return;
        }
        ListNode curr = head;
        ListNode prev = null;

        for(int i = 0; i < index; i++){
            prev = curr;
            curr = curr.next;
        }
        ListNode node = new ListNode(value);
        prev.next = node;
        node.next = curr;
        size++;
    }

    public void removeFirst(){
        if(head != null){
            head = head.next;
            size--;
        }
    }

    public void removeLast(){
        if(head == null){
            return;
        }
        if(head == tail){
            head = null;
            tail = null;
            size--;
            return;
        }
        ListNode curr = head;
        for(int i = 1; i < size-1; i++){
            curr = curr.next;
        }
        curr.next = null;
        tail = curr;
        size--;
    }

    public int get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Invalid Index");
        }

        ListNode curr = head;
        for(int i = 0; i < index; i++){
            curr = curr.next;
        }
        return curr.value;
    }

    public boolean containsValue(int value){
        ListNode node = head;
        while(node != null){
            if(node.value == value){
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public void reverse() {
        ListNode prev = null;
        ListNode curr = head;
        tail = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public int findMiddle() {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.value;
    }

    public boolean hasCycle() {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
