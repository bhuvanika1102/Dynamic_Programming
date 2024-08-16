
/*
 * In the previous question, the frog was allowed to jump either one or two steps at a time.
 *  In this question, the frog is allowed to jump up to ‘K’ steps at a time. 
 * If K=4, the frog can jump 1,2,3, or 4 steps at every index.
 */
import java.util.Arrays;

public class FrogJump_II_memo {
    private static int solve(int idx, int[] arr, int[] dp, int k) {
        if (idx == 0)
            return 0;
        if (dp[idx] != -1)
            return dp[idx];
        int minsteps = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (idx - i >= 0) {
                int jump = solve(idx - i, arr, dp, k) + Math.abs(arr[idx] - arr[idx - i]);
                minsteps = Math.min(jump, minsteps);
            }
        }
        return dp[idx] = minsteps;
    }

    public static void main(String[] args) {
        int[] heights = { 30, 10, 60, 10, 60, 50 };
        int num = heights.length;
        int k = 2;
        int[] dp = new int[num];
        Arrays.fill(dp, -1);
        System.out.println(solve(num - 1, heights, dp, k));
    }
}
