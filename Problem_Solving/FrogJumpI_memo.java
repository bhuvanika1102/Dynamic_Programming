
/*
 * Problem Statement:

Given a number of stairs and a frog, the frog wants to climb from the 0th stair to the (N-1)th stair.
 At a time the frog can climb either one or two steps. A height[N] array is also given. 
 Whenever the frog jumps from a stair i to stair j, the energy consumed in the jump is abs(height[i]- height[j]),
  where abs() means the absolute difference. 
We need to return the minimum energy that can be used by the frog to jump from stair 0 to stair N-1.
 */
import java.util.Arrays;

public class FrogJumpI_memo {
    private static int solve(int idx, int[] arr, int[] dp) {
        if (idx == 0)
            return 0;
        if (dp[idx] != -1)
            return dp[idx];
        int jumpone = solve(idx - 1, arr, dp) + Math.abs(arr[idx] - arr[idx - 1]);
        int jumptwo = Integer.MAX_VALUE;
        if (idx > 1) {
            jumptwo = solve(idx - 2, arr, dp) + Math.abs(arr[idx] - arr[idx - 2]);
        }
        return dp[idx] = Math.min(jumpone, jumptwo);
    }

    public static void main(String[] args) {
        int[] heights = { 30, 10, 60, 10, 60, 50 };
        int n = heights.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        System.out.println(solve(n - 1, heights, dp));
    }
}
