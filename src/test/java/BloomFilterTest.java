import basicStructures.BloomFilter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BloomFilterTest {
    @Test
    public void tes() {
        BloomFilter bloomFilter = new BloomFilter(32);
        bloomFilter.add("0123456789");
        bloomFilter.add("2345678901");
        bloomFilter.add("7890123456");
        assertTrue(bloomFilter.isValue("0123456789"));
        assertTrue(bloomFilter.isValue("2345678901"));
        assertTrue(bloomFilter.isValue("7890123456"));
        assertFalse(bloomFilter.isValue("qwerty"));
    }
}
