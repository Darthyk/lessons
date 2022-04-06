package recursion;

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
}
