
/*Problem Statement: Given a number of stairs. Starting from the 0th stair we need to climb to the “Nth” stair.
 At a time we can climb either one or two steps. 
We need to return the total number of distinct ways to reach from 0th to Nth stair. */
import java.util.Arrays;

public class ClimbStairs_memo {
    private static int solve(int idx, int[] dp) {
        if (idx == 0)
            return 1;
        if (idx == 1)
            return 1;
        if (dp[idx] != -1) {
            return dp[idx];
        }
        int left = solve(idx - 1, dp);
        int right = solve(idx - 2, dp);
        return dp[idx] = left + right;
    }

    public static void main(String[] args) {
        int num = 4;
        int[] dp = new int[num + 1];
        Arrays.fill(dp, -1);
        System.out.println(solve(num, dp));
    }

}
