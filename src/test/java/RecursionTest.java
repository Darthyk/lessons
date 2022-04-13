import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import recursion.Recursion;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    public void testArrayLengthCalculation() {
        assertEquals(0, Recursion.arrayLength(generateList(0)));
        assertEquals(1, Recursion.arrayLength(generateList(1)));
        assertEquals(100, Recursion.arrayLength(generateList(100)));
        assertEquals(1000, Recursion.arrayLength(generateList(1000)));
    }

    @Test
    public void testIsStringPalindrome() {
        assertTrue(Recursion.isPalindrome("ababa"));
        assertTrue(Recursion.isPalindrome("avavava"));
        assertTrue(Recursion.isPalindrome("abba"));

        assertTrue(Recursion.isPalindrome("aa"));
        assertTrue(Recursion.isPalindrome("a"));
        assertFalse(Recursion.isPalindrome("avav"));
    }

    @Test
    public void testEvenNumbers() {
        Recursion.getEvenNumber(generateList(9));
    }

    @Test
    public void testEvenPosition() {
        Recursion.getEvenPosition(generateList(10));
    }

    @Test
    public void testSecondMax() {
       List<Integer> integers = generateList(8);
       assertEquals(6, Recursion.getSecondMaximum(integers));
        List<Integer> integers1 = generateReversedList(8);
        assertEquals(7, Recursion.getSecondMaximum(integers1));
        Integer[] array = {1, 3, 8, 3,5,8};
        List<Integer> integers2 = Arrays.stream(array).collect(Collectors.toList());
        assertEquals(8, Recursion.getSecondMaximum(integers2));
    }

    @Test
    public void testSecondMax2() {
        List<Integer> integers = generateList(8);
        assertEquals(6, Recursion.getSecondMaximum2(integers));
        List<Integer> integers1 = generateReversedList(8);
        assertEquals(7, Recursion.getSecondMaximum2(integers1));
        Integer[] array = {1, 7, 6, 3,5,8};
        List<Integer> integers2 = Arrays.stream(array).collect(Collectors.toList());
        assertEquals(7, Recursion.getSecondMaximum2(integers2));
    }

    private List<Integer> generateList(int length) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            list.add(i);
        }
        return list;
    }

    private List<Integer> generateReversedList(int length) {
        List<Integer> list = new ArrayList<>();
        for (int i = length; i > 0; i--) {
            list.add(i);
        }
        return list;
    }
}
