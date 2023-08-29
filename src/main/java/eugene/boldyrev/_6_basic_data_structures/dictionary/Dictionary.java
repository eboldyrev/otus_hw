package eugene.boldyrev._6_basic_data_structures.dictionary;
public interface Dictionary<K, V> {

    V put(K key, V value);

    V get(K key);

    V del(K Key);

    int size();

    boolean isEmpty();

}
