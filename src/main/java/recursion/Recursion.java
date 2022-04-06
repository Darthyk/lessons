package recursion;

public class Recursion {
    public static int doExponentiation(int n, int m) {
        int result = 1;
        if ( m > 0) {
            result = n * doExponentiation(n, m - 1);
        }
        return result;
    }
}
