package recursion;

import java.util.List;

public class Recursion {
    public static int doExponentiation(int n, int m) {
        int result = 1;
        if ( m > 0) {
            result = n * doExponentiation(n, m - 1);
        }
        return result;
    }

    public static int numberSum(int number) {
        int result = 0;
        if (number > 0) {
            result += number % 10 + numberSum(number / 10);
        }
        return result;
    }

    public static int arrayLength(List<Integer> array) {
        if (array.isEmpty()) {
            return 0;
        } else {
            array.remove(0);
            return 1 + arrayLength(array);
        }
    }

    public static boolean isPalindrome(String str) {
        if (str.length() <= 1) {
            return true;
        } else {
            return str.charAt(0) == str.charAt(str.length() - 1) && isPalindrome(str.substring(1, str.length() - 1));
        }
    }
}
