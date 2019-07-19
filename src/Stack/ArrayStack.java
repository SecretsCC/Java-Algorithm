package Stack;

import java.util.Arrays;

public class ArrayStack {
    private int[] storage; //array of data
    private int capacity;
    private int count;
    private static final int GROW_FACTOR = 2;

    public ArrayStack() {
        this.capacity = 8;
        this.storage = new int[8];
        this.count = 0;
    }

    public ArrayStack(int initialCapacity) {
        if(initialCapacity < 1)
            throw new IllegalArgumentException("Capacity too small");

        this.capacity = initialCapacity;
        this.storage = new int[initialCapacity];
        this.count = 0;
    }

    //TODO: push
    public void push(int value) {
        if(count == capacity) {
            ensureCapacity();
        }
        storage[count++] = value;
    }

    //TODO: make sure capacity is enough
    public void ensureCapacity() {
        int newCapacity = capacity + GROW_FACTOR;
        storage = Arrays.copyOf(storage,newCapacity);
        capacity = newCapacity;
    }

    //TODO: pop()
    public int pop() {
        count--;
        if(count == -1) {
            throw new IllegalArgumentException("stack is empty");
        }
        return storage[count];
    }

    //TODO: peak()
    public int peak() {
        if(isEmpty()) {
            throw new IllegalArgumentException("stack is empty");
        }
        return storage[count-1];
    }

    //TODO: isEmpty()
    public boolean isEmpty() {
        return count == 0;
    }

    //TODO: size()
    public int size() {
        return count;
    }

}
