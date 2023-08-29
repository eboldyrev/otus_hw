package eugene.boldyrev._6_basic_data_structures.dictionary;

public abstract class AbstractDictionary<K, V> implements Dictionary<K, V>{

    protected Item<K, V>[] items;

    protected Item<K, V>[] EMPTY_ITEM = new Item[1];

    @Override
    public V put(K key, V value) {
        resize();
        items[size() - 1] = new Item<>(key, value);
        return null;
    }

    protected abstract void resize();

    @Override
    public V get(K key) {
        int idx = findKey(key);
        if (idx > -1) {
            return items[idx].value();
        }

        return null;
    }

    @Override
    public V del(K key) {
        int idx = findKey(key);
        if (idx > -1) {
            V value = items[idx].value();
            moveLeft(idx);
            return value;
        }

        return null;
    }

    protected int findKey(K key){
        for (int i = 0; i < size(); i++) {
            if (items[i].key().equals(key)) {
                return i;
            }
        }
        return -1;
    }

    protected void moveLeft(int fromIdx){
        if (fromIdx != size() - 1) {
            for (int i = fromIdx + 1; i < size(); i++) {
                items[i - 1] = items[i];
            }
        }
        items[size() - 1] = EMPTY_ITEM[0];
    }

    @Override
    public int size() {
        return items.length;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    public void print(){
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                System.out.printf("idx: %d | Item key=%s, value=%s \n", i, items[i].key(), items[i].value());
            } else {
                System.out.printf("idx: %d | Empty item\n", i);
            }
        }
    }
}
