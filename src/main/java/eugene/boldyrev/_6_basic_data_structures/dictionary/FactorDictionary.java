package eugene.boldyrev._6_basic_data_structures.dictionary;

public class FactorDictionary<K, V> extends AbstractDictionary<K, V> {

    private int factor;

    int size;

    public FactorDictionary() {
        items = new Item[10];
        this.factor = 2;
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
        Item<K, V>[] newItems = new Item[size() * factor + 1];

        for (int j = 0; j < size(); j++) {
            newItems[j] = items[j];
        }

        items = newItems;
    }

    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
