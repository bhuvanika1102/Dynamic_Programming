/*
 * TABULATION METHOD ==> BOTTOM UP
 * TC=>O(n)
 * SC=>O(n)
 */
public class Fibonacci_Tab {
    private static int fibonacci(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= num; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[num];
    }

    public static void main(String[] args) {
        int num = 11;
        System.out.println(fibonacci(num));
    }
}
