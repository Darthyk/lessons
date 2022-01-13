import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NativeDictionaryTest {
    @Test
    public void test() {
        NativeDictionary<Integer> nativeDictionary = new NativeDictionary<>(19, Integer.class);
        nativeDictionary.put("a", 1);
        assertTrue(nativeDictionary.isKey("a"));
        assertEquals(1, nativeDictionary.get("a"));
        nativeDictionary.put("a", 2);
        assertTrue(nativeDictionary.isKey("a"));
        assertEquals(2, nativeDictionary.get("a"));
        nativeDictionary.put("aa", 3);
        assertTrue(nativeDictionary.isKey("aa"));
        assertEquals(3, nativeDictionary.get("aa"));
        assertTrue(nativeDictionary.isKey("a"));
        nativeDictionary.put("ab", 4);
        assertEquals(3, nativeDictionary.get("aa"));
        assertTrue(nativeDictionary.isKey("ab"));
        assertEquals(4, nativeDictionary.get("ab"));
        assertNull(nativeDictionary.get("av"));
    }
}
