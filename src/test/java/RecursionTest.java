import org.junit.jupiter.api.Test;
import recursion.Recursion;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecursionTest {

    @Test
    public void testExponentiation() {
        assertEquals(8, Recursion.doExponentiation(2, 3));
        assertEquals(9, Recursion.doExponentiation(3, 2));
        assertEquals(27, Recursion.doExponentiation(3, 3));
        assertEquals(65536, Recursion.doExponentiation(2, 16));
    }

    @Test
    public void testNumberSum() {
        assertEquals(6, Recursion.numberSum(123));
        assertEquals(6, Recursion.numberSum(111111));
        assertEquals(14, Recursion.numberSum(2345));
        assertEquals(1, Recursion.numberSum(1));
    }
}
