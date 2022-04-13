package recursion;

import java.util.ArrayList;
import java.util.Arrays;
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

    public static Integer getSecondMaximum(int[] numbers) {
        quickSort(numbers, 0, numbers.length - 1);
        return numbers[numbers.length - 2];
    }

    public static int getMaximum(List<Integer> numbers, int lastMax) {
        if (numbers.size() > 1) {
            if (lastMax <= numbers.get(0)) {
                return getMaximum(numbers, numbers.get(0));
            }
            return getMaximum(numbers, lastMax);
        }
        return lastMax;
    }

    public static void quickSort(int[] numbers, int begin, int end) {
        if (end <= begin) return;
        int separator = separator(numbers, begin, end);
        quickSort(numbers, begin, separator-1);
        quickSort(numbers, separator+1, end);
    }

    public static int separator(int[] numbers,int begin, int end) {
        int separator = end;

        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (numbers[i] < numbers[separator]) {
                int temp = numbers[counter];
                numbers[counter] = numbers[i];
                numbers[i] = temp;
                counter++;
            }
        }
        int temp = numbers[separator];
        numbers[separator] = numbers[counter];
        numbers[counter] = temp;
        return counter;
    }

    public static Integer getSecondMaximum2(List<Integer> numbers) {
        int max = numbers.remove(0);
        int secondMax = Integer.MIN_VALUE;
        for (Integer i : numbers) {
            if (i > max) {
                secondMax = max;
                max = i;
                continue;
            }
            if (i > secondMax) {
                secondMax = i;
            }
        }
        return secondMax;
    }
}
