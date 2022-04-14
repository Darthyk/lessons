import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import recursion.Recursion2;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Recursion2Test {
    @Test
    public void testSecondMax() {
        Integer[] array1 = {0, 1,2,3,4,5,6,7};
        assertEquals(6, Recursion2.getSecondMaximum3(Arrays.stream(array1).collect(Collectors.toList())));
        Integer[] array2 = {7,8,6,5,4,3,2,1};
        assertEquals(7, Recursion2.getSecondMaximum3(Arrays.stream(array2).collect(Collectors.toList())));
        Integer[] array = {1, 10, 6, 3,5,8};
        List<Integer> integers2 = Arrays.stream(array).collect(Collectors.toList());
        assertEquals(8, Recursion2.getSecondMaximum3(integers2));
    }
}
