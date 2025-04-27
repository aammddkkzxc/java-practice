package hash.set;

import java.util.Arrays;
import java.util.LinkedList;

public class MyHashSet<E> implements MySet<E> {

    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    private LinkedList<E>[] buckets;

    private int size = 0;
    private int capacity = DEFAULT_INITIAL_CAPACITY;

    public MyHashSet() {
        initBuckets();
    }

    public MyHashSet(int initialCapacity) {
        this.capacity = initialCapacity;
        initBuckets();
    }

    private void initBuckets() {
        buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }


    @Override
    public boolean add(E element) {
        int hashIndex = hashIndex(element);
        LinkedList<E> bucket = buckets[hashIndex];

        if (bucket.contains(element)) {
            return false;
        }

        bucket.add(element);
        size++;
        return true;
    }

    @Override
    public boolean remove(E value) {
        int hashIndex = hashIndex(value);
        LinkedList<E> bucket = buckets[hashIndex];
        boolean result = bucket.remove(value);

        if (result) {
            size--;
            return true;
        }

        return false;
    }

    @Override
    public boolean contains(E searchValue) {
        int hashIndex = hashIndex(searchValue);
        LinkedList<E> bucket = buckets[hashIndex];
        return bucket.contains(searchValue);
    }

    private int hashIndex(Object value) {
        return Math.abs(value.hashCode()) % capacity;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "MyHashSetV3{" +
                "buckets=" + Arrays.toString(buckets) +
                ", size=" + size +
                ", capacity=" + capacity +
                '}';
    }
}
