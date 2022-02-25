import basicStructures.HashTable;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HashTableTest {
    @Test
    public void test() {
        HashTable table = new HashTable(19, 3);
        assertEquals(4 % 19, table.put("aaaa"));
        assertEquals(5 % 19, table.put("aaabf"));
        assertEquals(2 % 19, table.put("aa"));
        assertEquals(4 % 19, table.find("aaaa"));
        assertEquals(4 % 19 + 3, table.seekSlot("avby"));
    }
}
