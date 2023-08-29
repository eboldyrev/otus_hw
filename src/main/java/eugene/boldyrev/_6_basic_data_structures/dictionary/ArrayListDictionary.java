package eugene.boldyrev._6_basic_data_structures.dictionary;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDictionary<K, V> implements Dictionary<K, V> {

    private List<K> keys;
    private List<V> values;

    public ArrayListDictionary(){
        keys = new ArrayList<>();
        values = new ArrayList<>();
    }

    @Override
    public V put(K key, V value) {
        keys.add(key);
        values.add(value);
        return null;
    }

    @Override
    public V get(K key) {
        int index = keys.indexOf(key);
        if (index > -1) {
            return values.get(index);
        }

        return null;
    }

    @Override
    public V del(K key) {
        int index = keys.indexOf(key);
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return keys.size();
    }

    @Override
    public boolean isEmpty() {
        return keys.isEmpty();
    }
}
