package eugene.boldyrev._13_hash_table_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyHashTableTest {

    private MyHashTable<String, Integer> hashTable;

    @BeforeEach
    public void setup(){
        hashTable = new MyHashTable<>();
    }

    @Test
    public void put_notExising_success() {
        String key = "1";
        hashTable.put(key, 1);

        Integer actual = hashTable.get(key);
        assertEquals(1, actual);
    }

    @Test
    public void put_exising_success() {
        String key = "2";
        hashTable.put(key, 2);
        hashTable.put(key, 3);

        Integer actual = hashTable.get(key);
        assertEquals(3, actual);
    }

    @Test
    public void remove_exising_success() {
        String key = "2";
        hashTable.put(key, 2);

        hashTable.remove(key);
        Integer actual = hashTable.get(key);
        assertNull(actual);
    }

    @Test
    public void remove_non_exising_success() {
        String key = "2";

        hashTable.remove(key);
        Integer actual = hashTable.get(key);
        assertNull(actual);
    }

    @Test
    public void contains_exising_success() {
        String key = "1";
        hashTable.put(key, 1);

        boolean actual = hashTable.contains(key);
        assertTrue(actual);
    }

    @Test
    public void contains_not_exising_success() {
        String key = "1";

        boolean actual = hashTable.contains(key);
        assertFalse(actual);
    }

    @Test
    public void put_30_success() {
        for (int i = 0; i < 30; i++) {
            String key = ""+i;
            hashTable.put(key, i);
        }

        for (int i = 0; i < 30; i++) {
            String key = ""+i;
            Integer actual = hashTable.get(key);
            assertEquals(i, actual);
        }
    }
}
