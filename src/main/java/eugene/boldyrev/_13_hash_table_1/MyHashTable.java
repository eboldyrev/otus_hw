package eugene.boldyrev._13_hash_table_1;

import java.util.Arrays;
import java.util.Objects;

public class MyHashTable<K, V> {

    public static final int DEFAULT_CAPACITY = 11;

    public static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private int size;

    private int threshold;

    private MyEntry<K, V>[] buckets;


    public MyHashTable() {
        buckets = new MyEntry[DEFAULT_CAPACITY];
        threshold = (int) (DEFAULT_CAPACITY * DEFAULT_LOAD_FACTOR);
        System.out.println("THreshold=" + threshold);
    }

    public int getSize() {
        return size;
    }

    public V get(K key) {
        int idx = hash(key);
        MyEntry<K, V> e = buckets[idx];

        while (e != null) {
            if (e.key.equals(key)) {
                return e.value;
            }
            e = e.next;
        }
        return null;
    }

    public void put(K key, V value) {
        Objects.requireNonNull(key);

        int idx = hash(key);
        MyEntry<K, V> e = buckets[idx];

        while (e != null) {
            if (e.key.equals(key)) {
                e.setValue(value);
                return;
            }

            e = e.next;
        }

        if (++size > threshold) {
            rehash();
            idx = hash(key);
        }

        e = new MyEntry<>(key, value);

        // add to head
        e.next = buckets[idx];
        buckets[idx] = e;
    }

    public void remove(K key){
        int idx = hash(key);
        MyEntry<K, V> e = buckets[idx];
        MyEntry<K, V> last = null;

        while (e != null) {
            if (e.key.equals(key)) {
                if (last == null) { // remove the first element
                    buckets[idx] = e.next;
                } else { // not first
                    last.next = e.next;
                }
                size--;
            }
            last = e;
            e = e.next;
        }
    }
    public boolean contains(K key){
        int idx = hash(key);
        MyEntry<K, V> e = buckets[idx];

        while (e != null) {
            if (e.key.equals(key)) {
                return true;
            }
            e = e.next;
        }

        return false;
    }

    public void clear(){
        if (size > 0) {
            Arrays.fill(buckets, null);
            size = 0;
        }
    }

    private void rehash() {
        MyEntry<K, V>[] oldBuckets = buckets;
        int newCapacity = buckets.length * 2 + 1;
        threshold = (int) (newCapacity * DEFAULT_LOAD_FACTOR);
        buckets = new MyEntry[newCapacity];

        for (int i = oldBuckets.length - 1; i >= 0; i--) {
            MyEntry<K, V> e = oldBuckets[i];

            while (e != null) {
                int idx = hash(e.key);
                MyEntry<K, V> dest = buckets[idx];

                if (dest != null) {
                    MyEntry<K, V> next = dest.next;
                    while (next != null) {
                        dest = next;
                        next = dest.next;
                    }
                    dest.next = e;
                } else {
                    buckets[idx] = e;
                }

                MyEntry<K, V> next = e.next;
                e.next = null;
                e = next;
            }
        }
    }

    private int hash(K key) {
        int hash = key.hashCode() % buckets.length;
        return hash < 0? -hash : hash;
    }

    private static final class MyEntry<K, V> {

        private final K key;
        private V value;

        private MyEntry<K, V> next;

        MyEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MyEntry<?, ?> myEntry = (MyEntry<?, ?>) o;
            return key.equals(myEntry.key) && Objects.equals(value, myEntry.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }

}
