//MEMOIZATION(TOP-BOTTOM)
/*TC=>O(n)
 * SC=>O(n)+O(n)
 */
public class Fibonacci_memo {
    private static int fibonacci(int num) {
        int[] dp = new int[num + 1];
        if (num <= 1) {
            return num;
        }
        if (dp[num] != 0) {
            return dp[num];
        }
        return dp[num] = fibonacci(num - 1) + fibonacci(num - 2);
    }

    public static void main(String[] args) {
        int num = 11;
        System.out.println(fibonacci(num));
    }
}