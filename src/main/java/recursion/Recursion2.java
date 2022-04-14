package recursion;

import java.util.List;

public class Recursion2 {
    public static Integer getSecondMaximum3(List<Integer> numbers) {
        return getMinimumOfMaximums(numbers.remove(0), numbers.remove(0), numbers);
    }

    public static int getMinimumOfMaximums(int max1, int max2, List<Integer> numbers) {
        if (!numbers.isEmpty()) {
            if (max2 > max1) {
                return getMinimumOfMaximums(max2, max1, numbers);
            }
            Integer numberToCheck = numbers.remove(0);
            if (max1 < numberToCheck) {
                return getMinimumOfMaximums(numberToCheck, max1, numbers);
            }
            if (max2 <= numberToCheck) {
                return getMinimumOfMaximums(max1, numberToCheck, numbers);
            }
            return getMinimumOfMaximums(max1, max2, numbers);
        }
        return max2;
    }
}
