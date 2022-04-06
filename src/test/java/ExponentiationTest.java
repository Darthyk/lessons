import org.junit.jupiter.api.Test;
import recursion.Exponentiation;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExponentiationTest {

    @Test
    public void test1() {
        assertEquals(8, Exponentiation.doExponentiation(2, 3));
        assertEquals(9, Exponentiation.doExponentiation(3, 2));
        assertEquals(27, Exponentiation.doExponentiation(3, 3));
        assertEquals(65536, Exponentiation.doExponentiation(2, 16));
    }
}
