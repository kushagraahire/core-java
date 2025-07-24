package ArrayList;

public class CustomArrayList {
    private int[] arr;
    private final int DEFAULT_CAPACITY = 10;
    private int size = 0;
    private int capacity = 0;

    public CustomArrayList(){
        this.capacity = DEFAULT_CAPACITY;
        this.arr = new int[DEFAULT_CAPACITY];
    }

    public CustomArrayList(int capacity){
        this.capacity = capacity;
        this.arr = new int[capacity];
    }

    public void add(int value){
        if(size == capacity){
            resizeArray();
        }
        arr[size] = value;
        size++;
    }

    private void resizeArray() {
        int[] oldArr = arr;
        capacity *= 2;
        arr = new int[capacity];
        System.arraycopy(oldArr, 0, arr, 0, oldArr.length);
    }

    public int get(int index){
        if(index >= 0 && index < size){
            return arr[index];
        }
        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    public void remove(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        for(int i = index; i < size - 1; i++){
            arr[i] = arr[i+1];
        }
        arr[size-1] = 0;
        size--;
    }

    public int size() {
        return size;
    }
}
