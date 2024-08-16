/*TC=>O(n)
 * SC=>O(1)
 */
public class Fibonacci_Opti {
    private static int fibonacci(int num) {
        int prev = 1, prev1 = 0, curr = -1;
        for (int i = 2; i <= num; i++) {
            curr = prev + prev1;
            prev1 = prev;
            prev = curr;
        }
        return curr;
    }

    public static void main(String[] args) {
        int num = 11;
        System.out.println(fibonacci(num));
    }
}
