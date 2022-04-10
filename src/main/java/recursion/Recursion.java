package recursion;

import java.util.List;

public class Recursion {
    public static int doExponentiation(int n, int m) {
        if ( m > 0) {
            return n * doExponentiation(n, m - 1);
        }
        return 1;
    }

    public static int numberSum(int number) {
        if (number > 0) {
            return number % 10 + numberSum(number / 10);
        }
        return 0;
    }

    public static int arrayLength(List<Integer> array) {
        if (array.isEmpty()) {
            return 0;
        }
        array.remove(0);
        return 1 + arrayLength(array);
    }

    public static boolean isPalindrome(String str) {
        if (str.length() <= 1) {
            return true;
        }
        return str.charAt(0) == str.charAt(str.length() - 1) && isPalindrome(str.substring(1, str.length() - 1));
    }

    public static void getEvenNumber(List<Integer> numbers) {
        if (!numbers.isEmpty()) {
            Integer integer = numbers.remove(0);
            if (integer % 2 == 0) {
                System.out.println(integer);
            }
            getEvenNumber(numbers);
        }
    }

    public static void getEvenPosition(List<Integer> numbers) {
        if (numbers.size() > 2) {
            Integer integer = numbers.remove(0);
            System.out.println(integer);
            numbers.remove(0);
            getEvenNumber(numbers);
        }
    }
}
