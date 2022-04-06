import org.junit.jupiter.api.Test;
import recursion.Recursion;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecursionTest {

    @Test
    public void test1() {
        assertEquals(8, Recursion.doExponentiation(2, 3));
        assertEquals(9, Recursion.doExponentiation(3, 2));
        assertEquals(27, Recursion.doExponentiation(3, 3));
        assertEquals(65536, Recursion.doExponentiation(2, 16));
    }
}
