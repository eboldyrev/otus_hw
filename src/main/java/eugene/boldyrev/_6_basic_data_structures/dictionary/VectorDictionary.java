package eugene.boldyrev._6_basic_data_structures.dictionary;

public class VectorDictionary<K, V> extends AbstractDictionary<K, V> {

    private int delta;

    int size;

    public VectorDictionary(int delta){
        items = new Item[delta];
        this.delta = delta;
        size = 0;
    }

    @Override
    public V put(K key, V value) {
        if (size() == items.length) {
            resize();
        }
        items[size()] = new Item<>(key, value);
        size++;
        return null;
    }

    protected void resize() {
        Item<K, V>[] newItems = new Item[size() + delta];

        for (int j = 0; j < size(); j++) {
            newItems[j] = items[j];
        }

        items = newItems;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
