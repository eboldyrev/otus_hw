package eugene.boldyrev._6_basic_data_structures.dictionary;

public class SingleDictionary<K, V> extends AbstractDictionary<K, V> {

    public SingleDictionary(){
        items = new Item[0];
    }

    protected void resize() {
        Item<K,V>[] newItems = new Item[size() + 1];

        for (int j = 0; j < size(); j++) {
            newItems[j] = items[j];
        }

        items = newItems;
    }

}
